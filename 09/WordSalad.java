/* File: WordSalad.java - April 2018 */
package week09;

/**
 *  Distributes, Chops and Splits given words into blocks.
 *  Merges, joins and recombines words that have been sorted into blocks.
 *  @author Nathan Laing, Hugo Baird and Goran Topac
 */
public class WordSalad implements Iterable<String> {

    /**Creates variable first of WordNode class.*/
    private WordNode first;
    /**Creates variable last of WordNode class.*/
    private WordNode last;

    /**Constructor that sets WordNode varaiables to null. */
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    /**Constructor that calls the addLast method for each word in list.
     *@param words of type List.
     */
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    /**Creates instance of WordNode class for each word.
     *@param word of type String.
     */
    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }
    /**Call add method with word if not null.
     *@param word of type String.
     */
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast; 
    }
    /**Call length method return the length of a wordSalad.
     *@return len the length of the wordsalad.
     */
    public int length(){
        //returns the lengths of the word salad
        int len = 0;
        WordNode node  = first;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
    }
    /**
     * Gets the first node
     *@return first the first node
     */
    public WordNode getFirstNode(){
        return first;
    }
    /**Creates class WordNode to find next word in list.*/
    private class WordNode {
        /**Creates word of type String.*/
        private String word;
        /**Creates next of type WordNode.*/
        private WordNode next;
        /**Constructor to update variables word and next.
         *@param word of type String.
         *@param next of type WordNode.
         */      
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }

    }

    /**Creates and imports iterator.
     *@return result of the current word.
     */
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            private WordNode current = first;

            public boolean hasNext() {
                return current != null;
            }

            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**Creates block format for each of method results.
     *@return result of block format.
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }
    //// START OF STUDENT METHODS ////
    /**
     * Helper method: creates and returns an array of WordSalad objects.
     * @param k the number of blocks you want
     * @return blocks an array of WordSalad obj's
     */
    public WordSalad[] blockDivide(int k) {
        WordSalad[] blocks = new WordSalad[k];
        //Loop adds 'size' new WordSalad obj's to the array
        for(int blocksadded = 0; blocksadded < k; blocksadded++){   
            blocks[blocksadded] = new WordSalad();
        }
        return blocks;
    }

    /**
     * Helper method: creates and returns an array of WordSalad objects.
     * @return blocks an array of WordSalad obj's
     */
    public int getSize() {
        //Iterates through the nodes to get the size of a WordSalad obj.
        WordNode curr = this.first;
        int size = 1;
        while (curr != null){
            curr = curr.next;
            size++;
        }
        return size;
    }

    /**
     * Distributing and Merging the remainder until no words are left.
     * @param k the number of blocks
     * @return blocks[] array of WordSalad obj's
     */
    public WordSalad[] split(int k) {
        boolean wordsLeft = true;
        //Words Remaining
        WordSalad wr = this;
        int currentLength = 0;
        int tempLength = 0;
        WordSalad[] splitted = new WordSalad[currentLength];
        WordSalad[] current;
        WordSalad[] temp;

        //do while there are words left to sort in each block.
        while(wordsLeft){
            current = wr.distribute(k);
            currentLength = current.length;
            wr = merge(java.util.Arrays.copyOfRange(current, 1, currentLength));
            //if there is nothing in words, stop the loop.
            if(wr.first == null){
                wordsLeft = false;
            }
            temp = splitted;
            tempLength = temp.length;
            splitted = new WordSalad[tempLength + 1];

            for(int position = 0; position < tempLength; position++){
                splitted[position] = temp[position];
            } 
            splitted[tempLength] = current[0];

        }
        return splitted;    
    }
    /**
     * It add a word from a wordSalad to an other Wordsalad every mod.
     * @param mod rate at which it adds words.
     * @param toAdd the WordSalad it take word to add from.
     * @param result the wordSalad it add words to.
     * @return result the wordSalad with the words added to it.
     */
    public static WordSalad addWordsEvery(int mod, 
                                          WordSalad toAdd, WordSalad result){
        int emptyCount = -1;
        java.util.Iterator<String> addIter = toAdd.iterator();
        WordNode curNode = result.getFirstNode();
        while(addIter.hasNext()){
            if(curNode == null){
                curNode = result.getFirstNode();//make sure that it flips around
            }
            if(curNode.word.equals(" ")){
                emptyCount++;
                if(emptyCount % mod == 0){ 
                    curNode.word = addIter.next();
                }
            }

            curNode = curNode.next;
        }

        return result;
    }

    /**
     * Optional method: The opposite of split.
     * @param blocks an array of WordSalad objects to be merged.
     * @param k the size of the inserts
     * @return result a single WordSalad obj
     */
    public static WordSalad recombine(WordSalad[] blocks, int k){
        int wordNumber = 0;
        int i = 0;
        int countEmpty = 0;
        WordSalad result = new WordSalad();
        for(WordSalad block : blocks){
            wordNumber += block.length();
        }
        for(i = 0; i < wordNumber; i++){
            result.addLast(" ");
        }
        for(i = 0; i < blocks.length ; i++){
            result = addWordsEvery(k, blocks[i], result);
        }

        return result;
    }

    /**
     * WORKING.
     * Required method: Distributes words into k blocks as if dealing cards.
     * @param k the number of blocks.
     * @return WordSalad[] array of split WordSalads.
     */
    public WordSalad[] distribute(int k){

        WordSalad[] blocks = this.blockDivide(k);  // Makes a block to add into.

        WordNode position = this.first;

        int i = 0;  // To check which block we are adding into
        while(position != null){ // While we stil have works to add..

            if(i >= k){  // If we are at the last block switch back
                i = 0;
            }

            blocks[i].addLast(position.word);
            i++;

            if(position.next == null){  // Means we hit the last word
                return blocks;
            } else {               
                position = position.next;
            }
        }
        return blocks;
    }

    /**
     * WORKING.
     * Required method: Chops the words into k nearly even length blocks.
     * @param k the number of blocks.
     * @return cellBlock is a WordSalad[] array of split words.
     */
    public WordSalad[] chop(int k) {     
        int words = 0;
        WordNode curr = first;

        //Counts number of words in list
        while(curr != null){
            curr = curr.next;
            words++;
        }
        //Creates new WordSalad of number of blocks.
        WordSalad[] blocks = this.blockDivide(k);
        // Counts until wordLimit of block has been reached.
        int wordLimitCount = 1;
        //The word limit of each WordSalad based off words and blocks.
        int wordLimit = words / k;
        //Finds the remainder to check if extra words need to be added
        int remainder = words % k;
        int count = 0;

        //Creates k new WordSalad blocks 
        for(int x = 0; x < k; x++){
            blocks[x] = new WordSalad();
        }
        for(String word : this){
            if(word != null){
                blocks[count].addLast(word);
            }
            if(wordLimitCount < (wordLimit + (count < remainder ? 1 : 0))){
                wordLimitCount++;
            } else {
                count++;
                wordLimitCount = 1; 
            }
        }
        return blocks;
    }

    /**
     * Removes the nth words from all blocks and merges them back together.
     * @param blocks an array of WordSalad objects.
     * @return result a singular WordSalad object.
     */
    public static WordSalad merge(WordSalad[] blocks) {
        int sentenceLen = 0;
        for(WordSalad block : blocks){
            for(String word : block){
                sentenceLen++;
            }
        }
        WordSalad result = new WordSalad();
        int addingIndex = 0;
        while (result.getSize() <= sentenceLen){
            for (WordSalad block : blocks){
                int blockIndex = 0;
                for (String word : block){
                    // Key comparision for adding only nth word
                    if (blockIndex == addingIndex){
                        result.addLast(word);
                    }
                    blockIndex++;
                }
            }
            addingIndex++;
        }
        return result;
    }

    /**
     * Rejoins words from a sequence of blocks and returns them in order.
     * @param blocks the blocks of words that are to be rejoined.
     * @return w the result of rejoining the blocks into one WordSalad.
     */    
    public static WordSalad join(WordSalad[] blocks) {
        WordSalad joined = new WordSalad();
        // for each word in each block, add to joined
        for(WordSalad block: blocks){
            for(String s: block){
                joined.addLast(s);
            }
        }
        return joined;
    }
}
