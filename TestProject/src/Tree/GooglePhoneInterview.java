//How would you represent a social network in memory?
//Write a FriendSuggest function, which given a friend in the network, returns another person with whom this user shares the most number of friends.
//
//
//public class Person {
//	String name;
//	int age;
//	Date dob;...
//	public Person(String name, int age,...){
//		this.name = name;
//		
//	}
//	List<Person> connections;
//}
//
//2. A B c
//a - d
//b - d e
//c - f
//
//d - 2
//e - 1
//f - 1
// 
////inside person class
//Person friendSuggest(){
//	
//	HashMap<Person, Integer> cxnCnt = new HashMap<Person, Integer>();
//	HashMap<Person, Boolean> friendMap = new HashMap<Person, Boolean>();
//	for(int i = 0; i< connections.size(); i++){
//		friendMap.put(connections.get(i), true);
//	}
//	
//	for(int i=0; i< connections.size(); i++){
//		Person friend = connections.get(i);
//		for(int j=0; j<friend.connections.size(); j++){
//			Person friendOfFriend = friend.connections.get(j);
//			if(!friendOfFriend.equals((Person)this) && !friendMap.contains(friendOfFriend)){
//			if(cxnCnt.contains(friendOfFriend)){
//				cxnCnt.put(friendOfFriend,  cxnCnt.get(friendOfFriend)+1);
//			}
//			else cxnCnt.put(friendOfFriend, 1);
//		}
//		}
//	}
//	
//	return getTopCountedPerson(cnxCnt);
//}
//
////for extendibility - should be inside a utility class ideally
//Person getTopCountedPerson(Map<Person, Integer> cnxCnt){
// List<Map.Entry> listToSort =  new ArrayList<Map.Entry>(cnxCnt.entrySet());
//	Collections.sort(listToSort, new Comparator<Map.Entry>(){
//	@Override
//	public int compare(Map.Entry o1, Map.Entry o2){
//		return ((Comparable) (o2).getValue())
//      .compareTo((o1).getValue()));
//	}
//});
//
//Iterator it = listToSort.iterator();
//if(it.hasNext()) return it.next.getKey();
//return null;
//}
//
//
