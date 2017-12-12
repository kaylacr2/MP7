/**
 * Game for MP7. User plays as a student at U of I, and gets a personality
 * result, as well as try to find the hidden secrets.
 */
package rafloreseunjung;

import java.util.Scanner;

/**
 * @author Eunjung, Raflores
 */
public class UniGame {
	private Student player;
	private boolean[] confirm = {false, false, false}; // For hidden stories
	
	public UniGame() {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			try {
				// Greeting and introduce student
				System.out.println("Welcome to University of Illinois!"
						+ "\nWhat is your name?");
				String name = in.nextLine();
				System.out.println("What is your major? Pick from:"
						+ "\nCS, Business, Psychology, ECE, MCB, or Undeclared");
				String major = in.nextLine();
				player = new Student(name, major.toLowerCase());
				
				String course = "LAS101"; // Customized course
				String studyarea = "UGL"; // Customized study area
				if (player.getMajor().equals("cs")) {
					course = "CS125";
					studyarea = "Grainger";
				} else if (player.getMajor().equals("business")) {
					course = "BUS101";
					studyarea = "Gies";
				} else if (player.getMajor().equals("psychology")) {
					course = "PSYCH102";
				} else if (player.getMajor().equals("ece")) {
					course = "ECE120";
					studyarea = "your room";
				} else if (player.getMajor().equals("mcb")) {
					course = "MCB150";
				} else if (player.getMajor().equals("undeclared")) {
					course = "ANTH101";
				}
				
				if (player.getMajor().equals("business") || player.getMajor().equals("psychology")) {
					System.out.println("\nWow " + player.getName() + ", you’re so lucky to be a "
							+ player.getMajor().substring(0, 1).toUpperCase()
							+ player.getMajor().substring(1) + " major taking " + course + "!");
				} else if (player.getMajor().equals("cs") || player.getMajor().equals("ece") || player.getMajor().equals("mcb")) {
					System.out.println("\nWow " + player.getName() + ", you’re so lucky to be a "
							+ player.getMajor().toUpperCase() + " major taking " + course + "!");
				} else if (player.getMajor().equals("undeclared")) {
					System.out.println("\nWow " + player.getName() + ", you’re so lucky to be a student taking " + course + "!");
				}
				
				// Greeting and begin game
				System.out.println("\nHave fun today! Enter your answers as a single letter!");
			
				int ans = 0;
				while (ans == 0) {
					System.out.println("\nYou wake up. It’s 9:30 AM, almost time for your " + course + " class!"
							+ "\nYou:" +"\na. sleep more" + "\nb. go to 10:00 class");
					String input = in.nextLine();
					if (input.toLowerCase().equals("a")) {
						player.setHealth(player.getHealth() + 5); // Add 5 health pts
						ans = 1;
					} else if (input.toLowerCase().equals("b")) {
						player.setAcademic(player.getAcademic() + 5); // Add 5 academic pts 
						ans = 2;
					} else {
						System.out.println("Please enter your answer as a single letter!");
					}
				}
				
				// Sleep vs. Study
				if (ans == 1) {
					ans = 0;
					System.out.println("\nYou decide to sleep a few more hours. You wake up around lunchtime.");
				} else if (ans == 2) {
					ans = 0;
					while (ans == 0) {
						System.out.println("\nYou get to " + course + " and look around the room. Who do you sit next to?"
								+ "\nYou:" +"\na. sit next to your friend" + "\nb. sit alone to focus more");
						String input = in.nextLine();
						if (input.toLowerCase().equals("a")) {
							player.setSocial(player.getSocial() + 5); // Add 5 social pts
							ans = 1;
						} else if (input.toLowerCase().equals("b")) {
							player.setAcademic(player.getAcademic() + 5); // Add 5 academic pts 
							ans = 2;
						} else {
							System.out.println("Please enter your answer as a single letter!");
						}
					}
					
					ans = 0;
					while (ans == 0) {
						System.out.println("\nMost people have laptops and notebooks out."
								+ "\nYou:" +"\na. take notes" + "\nb. scroll social media (or UIUCMFUT)" + "\nc. take a little nap");
						String input = in.nextLine();
						if (input.toLowerCase().equals("a")) {
							player.setAcademic(player.getAcademic() + 2); // Add 2 academic pts
							ans = 1;
						} else if (input.toLowerCase().equals("b")) {
							player.setSocial(player.getAcademic() + 2); // Add 2 social pts 
							ans = 2;
						} else if (input.toLowerCase().equals("c")) {
							player.setHealth(player.getHealth() + 2); // Add 2 health pts
							ans = 3;
						} else {
							System.out.println("Please enter your answer as a single letter!");
						}
					}
					
					System.out.println("\nAfter class, it's just about time for lunch.");
				}
				
				// Lunchtime return to normal arc
				ans = 0;
				while (ans == 0) {
					System.out.println("You decide to eat:" +"\na. mcdonalds" + "\nb. chipotle" 
							+ "\nc. dining hall food" + "\nd. nothing");
					String input = in.nextLine();
					if (input.toLowerCase().equals("a")) {
						player.setFinancial(player.getFinancial() + 3); // Add 3 financial pts
						player.setHealth(player.getHealth() + 1); // Add 1 health pt
						ans = 1;
					} else if (input.toLowerCase().equals("b")) {
						player.setFinancial(player.getFinancial() + 2); // Add 2 financial pts
						player.setHealth(player.getHealth() + 2); // Add 2 health pts
						ans = 2;
					} else if (input.toLowerCase().equals("c")) {
						System.out.println("\nYou ran out of meal credits."
								+ "\nYou:" +"\na. pay your own money and eat lunch at dining hall" + "\nb. go back");
						String input1 = in.nextLine();
						if (input1.toLowerCase().equals("a")) {
							player.setFinancial(player.getFinancial() + 1); // Add 1 financial pts
							player.setHealth(player.getHealth() + 4); // Add 4 health pt
							ans = 3;
						}
					} else if (input.toLowerCase().equals("d")) {
						player.setFinancial(player.getFinancial() + 5); // Add 5 financial pts
						player.setHealth(player.getHealth() - 1); // Subtract 1 health pt
						ans = 4;
					} else {
						System.out.println("Please enter your answer as a single letter!");
					}
				}
				
				// Next class normal arc
				ans = 0;
				while (ans == 0) {
					System.out.println("\nYou decide to head to your next class, an AAS100 discussion."
							+ "\nYou:" +"\na. participate and answer questions" + "\nb. snapchat with your friends"
							+ "\nc. go online holiday browsing" + "\nd. write down what you see on the board and doze off");
					String input = in.nextLine();
					if (input.toLowerCase().equals("a")) {
						player.setAcademic(player.getAcademic() + 5); // Add 5 academic pts
						ans = 1;
					} else if (input.toLowerCase().equals("b")) {
						player.setSocial(player.getSocial() + 5); // Add 5 social pts 
						ans = 2;
					} else if (input.toLowerCase().equals("c")) {
						player.setSocial(player.getSocial() + 3); // Add 3 social pts 
						player.setFinancial(player.getFinancial() - 2); // Subtract 2 financial pts
						ans = 3;
					}  else if (input.toLowerCase().equals("d")) {
						player.setAcademic(player.getAcademic() + 2); // Add 2 academic pts
						player.setHealth(player.getHealth() + 3); // Add 3 health pts
						ans = 4;
					} else {
						System.out.println("Please enter your answer as a single letter!");
					}
				}
				
				// After school activities
				ans = 0;
				while (ans == 0) {
					System.out.println("\nFinally, school is over. You have some free time."
							+ "\nYou:" +"\na. head on down to green st for a quick snack" + "\nb. go to " + studyarea + " to study " + course
							+ "\nc. go to the ARC to work out" + "\nd. head to your friend's place for a pregame");
					String input = in.nextLine();
					if (input.toLowerCase().equals("a")) {
						player.setFinancial(player.getFinancial() - 2); // Subtract 2 financial pts
						ans = 1;
					} else if (input.toLowerCase().equals("b")) {
						player.setFinancial(player.getFinancial() + 5); // Add 5 financial pts
						player.setAcademic(player.getAcademic() + 3); // Add 3 academic pts
						ans = 2;
					} else if (input.toLowerCase().equals("c")) {
						player.setFinancial(player.getFinancial() + 5); // Add 5 financial pts
						player.setHealth(player.getHealth() + 3); // Add 3 health pts
						ans = 3;
					}  else if (input.toLowerCase().equals("d")) {
						player.setFinancial(player.getFinancial() + 3); // Add 5 financial pts
						player.setSocial(player.getSocial() + 3); // Add 3 social pts
						ans = 4;
					} else {
						System.out.println("Please enter your answer as a single letter!");
					}
				}
				
				// After school activities continued
				if (ans == 1) {
					ans = 0;
					while (ans == 0) {
						System.out.println("\nWhile walking down Green St., you notice something shimmer out of the corner of your eye."
								+ "\nYou:" +"\na. believe that the shimmer must be mcdonalds and go eat there"
								+ "\nb. try to follow the shimmer down another block"
								+ "\nc. are uninspired by the shimmer and pick up a snack at a cafe");
						String input = in.nextLine();
						if (input.toLowerCase().equals("a")) {
							player.setFinancial(player.getFinancial() + 4); // Add 4 financial pts
							player.setHealth(player.getHealth() + 1); // Add 1 health pt
							ans = 1;
						} else if (input.toLowerCase().equals("b")) {
							player.setAcademic(player.getAcademic() + 2); // Add 2 academic pts
							ans = 2;
						} else if (input.toLowerCase().equals("c")) {
							player.setFinancial(player.getFinancial() + 2); // Add 3 financial pts
							player.setHealth(player.getHealth() + 3); // Add 3 health pts
							ans = 3;
						} else {
							System.out.println("Please enter your answer as a single letter!");
						}
					}
					
					if (ans == 2) {
						ans = 0;
						while (ans == 0) {
							System.out.println("\nThe shimmer, more like a glint of light in your peripheral vision, leads"
									+ "\nyou to a building you've never seen before. In front of you are 2 doors."
									+ "\nYou:" +"\na. open the door on the left because it looks bigger"
									+ "\nb. open the door on the right because right is right"
									+ "\nc. decide that shimmer could have been the glint of something dangerous and leave");
							String input = in.nextLine();
							if (input.toLowerCase().equals("a")) {
								confirm[0] = true;
								ans = 1;
							} else if (input.toLowerCase().equals("b")) {
								confirm[1] = true;
								ans = 2;
							} else if (input.toLowerCase().equals("c")) {
								player.setHealth(player.getHealth() + 1); // Add 1 health pt
								ans = 3;
							} else {
								System.out.println("Please enter your answer as a single letter!");
							}
						}
						
						if (ans == 1) {
							System.out.println("\nYou open the door to reveal a vast emptiness, U of I's personal hidden"
									+ "\nvoid. You quickly shut it and return back to your dorm.");
						} else if (ans == 2) {
							System.out.println("\nYou open the door to reveal dozens of squirrels. You have just spoiled the"
									+ "\nreveal of U of I's newest mascot. You quickly shut it and return back to your dorm.");
						}
					}
				} else if (ans == 2) {
					ans = 0;
					while (ans == 0) {
						System.out.println("\nYou get to " + studyarea + " and see that a group of your friends are already studying,"
								+ "\nor so it seems. Half of them are on Instagram and the other half are grinding through Webassigns."
								+ "\nYou:" + "\na. sit with your friends who are chillin" + "\nb. sit with your friends who are workin"
								+ "\nc. sit elsewhere to concentrate better");
						String input = in.nextLine();
						if (input.toLowerCase().equals("a")) {
							player.setAcademic(player.getAcademic() + 3); // Add 3 academic pts
							player.setSocial(player.getSocial() + 2); // Add 2 social pts
							ans = 1;
						} else if (input.toLowerCase().equals("b")) {
							player.setAcademic(player.getAcademic() + 4); // Add 4 academic pts
							player.setSocial(player.getSocial() + 1); // Add 1 social pt
							player.setFinancial(player.getFinancial() + 1); // Add 1 financial pt, getting help from friends rather than Chegg
							ans = 2;
						} else if (input.toLowerCase().equals("c")) {
							player.setAcademic(player.getAcademic() + 5); // Add 5 academic pts
							player.setHealth(player.getHealth() + 1); // Add 1 health pt
							ans = 3;
						} else {
							System.out.println("Please enter your answer as a single letter!");
						}
					}
				} else if (ans == 3) {
					ans = 0;
					while (ans == 0) {
						System.out.println("\nAt the ARC, there are a lot of people already working out, but something unusual catches your eye."
								+ "\nYou:" +"\na. investigate" + "\nb. head to the weightlifting area"
								+ "\nc. check out your friend's dance workshop");
						String input = in.nextLine();
						if (input.toLowerCase().equals("a")) {
							player.setAcademic(player.getAcademic() + 2); // Add 2 academic pts
							confirm[2] = true;
							ans = 1;
						} else if (input.toLowerCase().equals("b")) {
							player.setHealth(player.getHealth() + 3); // Add 4 health pts
							ans = 2;
						} else if (input.toLowerCase().equals("c")) {
							player.setHealth(player.getHealth() + 2); // Add 2 health pts
							player.setSocial(player.getSocial() + 2); // Add 2 social pts
							ans = 3;
						} else {
							System.out.println("Please enter your answer as a single letter!");
						}
					}
					
					if (ans == 1) {
						System.out.println("You follow your instincts and investigate Multipurpose Room 7. Inside, a circle of students"
								+ "\nare sitting at their laptops. When you ask what they are doing, they say 'exercises'. But when"
								+ "\nyou look at one of the student's laptops, they just have Turing's craft open. Then you realize --"
								+ "\nthere is no MP 7.");
					}
				} else if (ans == 4) {
					ans = 0;
					while (ans == 0) {
						System.out.println("\nWhen you get to your friend's place, the fun has just begun."
								+ "\nYou:" + "\na. prep your mind and bod because you're going all out tonight"
								+ "\nb. lay back because chilling with music and your friends is Just about all you need");
						String input = in.nextLine();
						if (input.toLowerCase().equals("a")) {
							player.setHealth(player.getHealth() + 1); // Add 1 health pt
							player.setSocial(player.getSocial() + 4); // Add 4 social pts
							player.setFinancial(player.getFinancial() - 2); // Subtract 2 financial pts
							ans = 1;
						} else if (input.toLowerCase().equals("b")) {
							player.setHealth(player.getHealth() + 2); // Add 2 health pts
							player.setSocial(player.getSocial() + 3); // Add 3 social pts
							player.setFinancial(player.getFinancial() - 1); // Subtract 1 financial pt
							ans = 2;
						} else {
							System.out.println("Please enter your answer as a single letter!");
						}
					}
				}
				
				// End of day return to normal arc
				ans = 0;
				while (ans == 0) {
					System.out.println("\nYou've had a long day. Thoroughly exhausted, you:"
							+ "\na. hit the bed as soon as you see it" + "\nb. take a shower and get ready for bed"
							+ "\nc. pull out your laptop for some last minute studying before heading to bed"
							+ "\nd. scroll your phone a bit before knocking out for the night");
					String input = in.nextLine();
					if (input.toLowerCase().equals("a")) {
						player.setHealth(player.getHealth() + 3); // Add 3 health pts
						ans = 1;
					} else if (input.toLowerCase().equals("b")) {
						player.setHealth(player.getHealth() + 5); // Add 5 health pts
						ans = 2;
					} else if (input.toLowerCase().equals("c")) {
						player.setAcademic(player.getAcademic() + 3); // Add 3 academic pts
						ans = 3;
					}  else if (input.toLowerCase().equals("d")) {
						player.setSocial(player.getSocial() + 3); // Add 3 social pts
						ans = 4;
					} else {
						System.out.println("Please enter your answer as a single letter!");
					}
				}
				
				// Results
				String monies = "";
				if (player.getFinancial() > 2) {
					monies = "\nYou're pretty good with money; you're the type that'd rather relax with friends"
							+ "\nthan do something extravagant.";
				} else {
					monies = "\nYou might want to watch your spending; sometimes food gets the best of you.";
				}
				
				String secrets = "";
				if (confirm[0] && confirm [1] && confirm[2]) {
					secrets = "\nCongratulations on discovering all the secrets of this game. You're one step"
							+ "\ncloser to becoming the block I.";
				} else if (confirm[0] || confirm[1] || confirm[2]) {
					secrets = "\nYou have yet to discover all the secrets of this game; play again for more.";
				} else {
					secrets = "\nThere are secrets to this game you haven't discovered yet. Play again to uncover"
							+ "\nU of I's true secrets";
				}
				
				System.out.println("\nYour Results:");
				if ((player.getHealth() > 9 && player.getAcademic() < 11 && player.getSocial() > 8)
						|| (player.getHealth() > 9 && player.getAcademic() < 11 && player.getSocial() < 8)) {
					System.out.println("Much like an ice cube, you love to chill. You're the 'sweet' one and the one people love to"
							+ "\ndepend on, because it seems like you have your life together. Sometimes you're a mess, but you"
							+ "\ntry your best and should definitely try a little more in classes." + monies + secrets);
				} else if ((player.getHealth() > 9 && player.getAcademic() > 11 && player.getSocial() > 8)
						|| (player.getHealth() > 9 && player.getAcademic() > 11 && player.getSocial() < 8)) {
					System.out.println("'Grind' is your middle name, because you're always on it. Your favorite spot on"
							+ "\ncampus is lowkey the UGL, of course, after your bed. You prioritize grades and sleep, but"
							+ "definitely spend your free time eating. You like to hang, but don't always have time." + monies + secrets);
				} else if ((player.getHealth() < 9 && player.getAcademic() < 11 && player.getSocial() > 8)
						|| (player.getHealth() < 9 && player.getAcademic() > 11 && player.getSocial() > 8)) {
					System.out.println("Anyone can tell right away that you're a friendly person. Every day is a new day of"
							+ "\nwildin, but you should definitely try to get more sleep during the week. You're always asking"
							+ "\neveryone what the homework was, even if it's right in front of you." + monies + secrets);
				} else if ((player.getHealth() < 9 && player.getAcademic() < 11 && player.getSocial() < 8)
						|| (player.getHealth() < 9 && player.getAcademic() > 11 && player.getSocial() < 8)) {
					System.out.println("Sleep? What is that? Socializing? Huh? You're more introverted than the rest, but that"
							+ "\ndoesn't stop you from having a good time. You're the one people love to hang out with, even if"
							+ "\nyou're not always at your best. You're lowkey savage and the person people want to get to know." + monies + secrets);
					
				} else {
					System.out.println("When you walk down the street, people say 'who is she?' not because they don't"
							+ "\nknow you, but because they wish they did. You're a cool person all around, and would"
							+ "\ndeep down, take your studies pretty seriously." + monies + secrets);
				}
				
			}
			catch (InvalidMajorException e) {
				System.out.println(e);
			}
			
			// If student is done playing, end game
			System.out.println("\nAre you done playing? Y or N");
			String ans = in.nextLine();
			if (ans.toLowerCase().equals("y") || ans.toLowerCase().equals("yes")
					|| ans.toLowerCase().equals("ya")) {
				done = true;
			}
		}
		in.close();
	}
	
	public static void run() {
		UniGame g = new UniGame();
	}
	
	public static void main(String[] args) {
		run();
	}
}
