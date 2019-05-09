/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {

        int positionOfList0 = start0;
        int positionOfList1 = start1;

        ArrayList<String> sortedList = new ArrayList<String>();

        for (int i = 0; i < start0; i ++) {
            sortedList.add(usersData.get(i));
        }
        while (positionOfList0 < start1 && positionOfList1 < nItems) { //check to see if there are still elements to compare
          if (usersData.get(positionOfList0).compareTo(usersData.get(positionOfList1)) < 1) {
            sortedList.add(usersData.get(positionOfList0));
            positionOfList0++;
          } else {
            sortedList.add(usersData.get(positionOfList1));
            positionOfList1++;
          }
        }
        while (positionOfList0 < start1) { //check if there are still elements in list0
          sortedList.add(usersData.get(positionOfList0));
          positionOfList0++;
        }
        while (positionOfList1 < nItems) { //check if there are still elements in list1
          sortedList.add(usersData.get(positionOfList1));
          positionOfList1++;
        }
        for (int i = nItems ; i < usersData.size(); i ++) {
            sortedList.add(usersData.get(i));
        }
        usersData = sortedList;
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}
