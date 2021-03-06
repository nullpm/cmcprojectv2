/**
 * File: User.java
 */

package baseclasses;

import java.util.ArrayList;

import controllers.SearchController;

/**
 * This is the User base class
 * 
 * @author mjzent
 * @version 0.1
 */
public class User extends Account{
	
	/**
	 * savedUniversities is an arraylist of saved universities
	 */
	private ArrayList<University> savedUniversities;

	/**
	 * This creates a new User and fills the fields required for all accounts
	 */
	public User(String username, String firstName, String lastName, String password, char type, char status, ArrayList<University> schools){
		super(username,firstName,lastName,password,type,status);
		savedUniversities = schools;
	}
	/**
	 * This method gets a list of this users saved universities
	 * 
	 * @return the savedUniversities
	 */
	public ArrayList<University> getSavedUniversities() {
		return savedUniversities;
	}

	/**
	 * This method adds a university to this users list of saved universities
	 * 
	 * @param savedUniversities the savedUniversities to set
	 * @return whether or not the university could be added
	 */
	public boolean addUniversities(University u) {

		return savedUniversities.add(u);
	}
	
	/**
	 * This method removes a university from the users list of saved universities
	 * 
	 * @param u is school to be removed from saved universities
	 * @return whether the remove was successful
	 */
	public boolean removeSchool(University u){
		for(University u2 : savedUniversities){
			if(u2.getName().equals(u.getName())){
				 return savedUniversities.remove(u2);
			}
		}
		return false;
	}
	
	/**
	 * This method views the details of a university
	 * 
	 * @param u is the school to be viewed
	 * @return a string representation of university details
	 */
	public String viewSchool(University u){
		return u.getInformation();
	}
	/**
	 * This method views the details of a university as well as the details of similar universities
	 * 
	 * @param u is the school to be viewed and to find similar universities to
	 * @return a string representation of university details and details of similar universities
	 */
	
	public String viewSchoolWRec(University u){
		String ret = u.getInformation();
		SearchController search = new SearchController();
		ArrayList<University> recs = search.findRelatedUniversities(u, 5);
		for(int i = 0;i < 5;i++){
			ret = ret + "\n" + recs.get(i).getInformation();
		}
		return ret;
	}
	
	@Override
	  public boolean equals(Object o){
		  
		    if (this == o){
		        return true;
		    }
		    if (o == null){
		        return false;
		    }
		    if (Account.class != o.getClass()){
		        return false;
		    }
		    return this.getUsername().equals(((Account) o).getUsername());
		    	
	  }
	
}
