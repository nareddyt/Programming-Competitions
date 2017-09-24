import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Solution for Cows and Folders
 *
 * @version 1.0
 * @author tejasvi.nareddy
 */
public class Solution {
    public static void main(String args[]) throws Exception {
        // TODO try-catch

        // Setup buffer reader to read file line-by-line
        FileReader fileReader = new FileReader("A-small-attempt0.in");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer stringTokenizer;

        // Get number of cows from file
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numCows = Integer.parseInt(stringTokenizer.nextToken());

        // Get number of shared and confidential folders
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numSharedFolders = Integer.parseInt(stringTokenizer.nextToken());
        int numConfidentialFolders = Integer.parseInt(stringTokenizer.nextToken());

        // Construct maps of (folder_number -> cows with explicit access to folder)
        Map<Integer, Set<Integer>> sharedFolderAccess = buildFolderAccessMap(numSharedFolders, stringTokenizer, bufferedReader);
        Map<Integer, Set<Integer>> confidentialFolderAccess = buildFolderAccessMap(numConfidentialFolders, stringTokenizer, bufferedReader);

        // Get the number of relations
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numFolderRelations = Integer.parseInt(stringTokenizer.nextToken());

        // Start constructing the tree for the folder hierarchy
        // Let us keep track of potential candidates for root nodes. When some node becomes the child of another one,
        // then we know this can't be the root. Given correct input, we should end up with only one root node.
        HashMap<Integer, Folder> potentialRoots = new HashMap<>();
        for (int i = 0; i < numFolderRelations; i++) {
            // Get the parent folder id and the child folder id
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentId = Integer.parseInt(stringTokenizer.nextToken());
            int childId = Integer.parseInt(stringTokenizer.nextToken());

            // Make the child folder with no other children if it does not exist
            Folder childFolder = potentialRoots.get(childId);
            if (childFolder == null) {
                Set<Integer> childAccessors;
                if (sharedFolderAccess.containsKey(childId)) {
                    childAccessors = sharedFolderAccess.get(childId);
                    childFolder = new SharedFolder(childAccessors);
                } else {
                    childAccessors = confidentialFolderAccess.get(childId);
                    childFolder = new ConfidentialFolder(childAccessors);
                }
            } else {
                // We know this is a child now!
                potentialRoots.remove(childId);
            }

            // Make the parent folder
            Set<Integer> parentAccessors;
            Folder parentFolder;
            if (sharedFolderAccess.containsKey(parentId)) {
                parentAccessors = sharedFolderAccess.get(parentId);
                parentFolder = new SharedFolder(parentAccessors);
            } else {
                parentAccessors = confidentialFolderAccess.get(parentId);
                parentFolder = new ConfidentialFolder(parentAccessors);
            }

            // Set the parent's children
            parentFolder.addChildFolder(childFolder);

            // Add the parent id to the potential roots
            potentialRoots.put(parentId, parentFolder);
        }

        // Ensure we only have 1 potential root
        if (potentialRoots.size() > 1) {
            throw new IllegalAccessException("Could not determine a root: " + potentialRoots.toString());
        }

        // Get the uncool cows for the root, this will calculate everything using recursion!
        Set<Integer> uncoolCows = getUncoolCows(potentialRoots.values().iterator().next(), new HashSet<>(), numCows);

        // Print them out
        for (int cow : uncoolCows) {
            System.out.print(cow + " ");
        }
    }

    /**
     * Sorry running out of time can't do real javadocs or comments, but this essentially:
     * - traverses the tree (top to bottom) adding implicit accessors / cows
     * - determines which cows are uncool when it reaches leaf folders
     * - passes those uncool cows back up, UNIONing the sets to get a full list of uncool cows
     * @param root
     * @param implicitAccessors
     * @param totalCows
     * @return
     */
    private static Set<Integer> getUncoolCows(Folder root, Set<Integer> implicitAccessors, int totalCows) {
        // Add the implicit accessors previously passed in. Note these are set / ignored based on the actual runtime type
        // of the folder (set when we constructed the tree).
        root.addImplicitAccessors(implicitAccessors);

        // Determine uncool cows for this folder
        Set<Integer> uncoolCows = new HashSet<>();

        if (root.getChildren().size() == 0) {
            // This is a leaf folder (base case)
            // Determine uncool cows of this folder
            for (int i = 0; i < totalCows; i++) {
                if (!root.getChildren().contains(i)) {
                    uncoolCows.add(i);
                }
            }
            return uncoolCows;
        }

        // Otherwise, this has children folders
        // Get uncool cows of children folders and union them
        for (Folder child : root.getChildren()) {
            // note: Pass this folder's accessors as the child folder's implicit accessors
            Set<Integer> childUncoolCows = getUncoolCows(child, root.getAccessors(), totalCows);
            uncoolCows.addAll(childUncoolCows);
        }

        return uncoolCows;
    }

    private static Map<Integer, Set<Integer>> buildFolderAccessMap(int numFolders, StringTokenizer stringTokenizer,
                                                                   BufferedReader bufferedReader) throws IOException {
        Map<Integer, Set<Integer>> folderAccessMap = new HashMap<>();

        for (int i = 0; i < numFolders; i++) {
            // Get the access info for the given folder
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            // Parse the folder id
            int folderId = Integer.parseInt(stringTokenizer.nextToken());

            // Setup the map with an empty list for the folder id, as no cows have access to the folder yet
            // TODO ensure the folder id does not repeat
            Set<Integer> cowsWithAccess = new HashSet<>();
            folderAccessMap.put(folderId, cowsWithAccess);

            // Parse number of cows with access to folder
            int numCowsWithAccess = Integer.parseInt(stringTokenizer.nextToken());

            // Parse through each of the cows with access, adding them to the map
            for (int j = 0; j < numCowsWithAccess; j++) {
                // Parse the cow id
                int cowId = Integer.parseInt(stringTokenizer.nextToken());

                // Add the cow to the list that has access. Note this change is automatically reflected in the map
                cowsWithAccess.add(cowId);
            }
        }

        return folderAccessMap;
    }

    // TODO access modifiers
    public static abstract class Folder {
        private Set<Integer> accessors = new HashSet<>();
        private Set<Folder> children = new HashSet<>();

        public Folder(Set<Integer> accessors) {
            addExplicitAccessors(accessors);
        }

        public void addChildFolder(Folder folder) {
            children.add(folder);
        }

        public Set<Folder> getChildren() {
            return children;
        }

        void addExplicitAccessors(Set<Integer> accessors) {
            this.accessors.addAll(accessors);
        }

        public Set<Integer> getAccessors() {
            return accessors;
        }

        public abstract void addImplicitAccessors(Set<Integer> accessors);
    }

    public static class SharedFolder extends Folder {
        public SharedFolder(Set<Integer> accessors) {
            super(accessors);
        }

        public void addImplicitAccessors(Set<Integer> accessors) {
            // Treat the implicit accessors are regular accessors
            super.addExplicitAccessors(accessors);
        }
    }

    public static class ConfidentialFolder extends Folder {
        public ConfidentialFolder(Set<Integer> accessors) {
            super(accessors);
        }

        public void addImplicitAccessors(Set<Integer> accessors) {
            // Do nothing as confidential folders should get no implicit accessors
        }
    }
}
