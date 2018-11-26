package Friend;

import java.util.ArrayList;

public interface FriendDBA {
	
	public void friendInsert(Friend f);
	public ArrayList<Friend> friendView();
	public ArrayList<Friend> friendSearch(String str);

}
