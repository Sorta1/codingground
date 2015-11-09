//Author Nathan Chin and Sam orta
//Last edited 11/6/15
import java.util.*;

public class Magpie
{
//Declare a scanner
	public static void main(String[] args) throws java.lang.Exception
	{
		Magpie maggie = new Magpie();
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		//How to quit the program
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			//System.out.println (maggie.findKeyword("She's my sister", "sister",0));
			statement = in.nextLine();
		}
		in.close();
	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
	//Our first question
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.trim().length() == 0)
		{
			response = "Please say something"; 			
		}
		else if (findKeyword(statement, "no", 0) >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "java", 0) >= 0)
		{
			response = "That's my favorite language!";
		}
		else if (findKeyword(statement,"school", 0) >= 0)
		{
			response = "Tell me more about school";
		}
		else if (findKeyword(statement,"hello",0) >= 0)
		{
			response = "Hello, tell me about your day?";
		}
		else if (findKeyword(statement,"mother",0) >= 0
				|| findKeyword(statement,"father",0) >= 0
				|| findKeyword(statement,"sister",0) >= 0
				|| findKeyword(statement,"brother",0) >= 0)
		{
		  //Random response if family is mentioned
		    private String getFamilyResponse ()
	      {
		    Random f = new Random();
		    return randomFamily [r.nextInt(randomFamily.length)];
	      }
	      String[] randomFamily = {
	      "Do you have any grandparents?",
			  "Older or younger siblings?",
			  "Do you really think so?",
			  "Any other siblings",
			  "Are you parents around often?",
			  "What do they do for a living?",
			  "Do you get along with your family?",
	       }; 
	      } 
		else if (findKeyword(statement,"cat",0) >= 0
				|| findKeyword(statement, "dog",0) >= 0)
		{
			response = "Tell me more about your pets.";
		}
		//A specalized resposne for Raj
		else if (findKeyword(statement, "Dr. Raj",0) >= 0)
		{
			response = "He sounds like a good teacher";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.toLowerCase().indexOf(
				goal.toLowerCase(), startPos);
	    // at this point, if psn found the goal string inside
	    // the statement, it is psn is 0 or greater 

		// Refinement--no to make sure that the goal isn't part of a
		// word, like "no" inside "knowledge"
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word- we want to grap the the letter before and
			// after the found string.
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn)
						.toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1)
						.toLowerCase();
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}
			// We only get to this part of the code if
			// the last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(),
					psn + 1);

		}

		return -1;
	}
	//Random responses if computer can't find anything else to respond to.
	private String getRandomResponse ()
	{
		Random r = new Random();
		return randomResponses [r.nextInt(randomResponses.length)];
	}

	String[] randomResponses = {
	    "Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"Really?",
			"That's pretty cool",
			"Is that so?",
	};
}
