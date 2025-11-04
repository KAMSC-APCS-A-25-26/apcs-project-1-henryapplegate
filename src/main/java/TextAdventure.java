import java.util.Scanner;

public class TextAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean play = true;

        while (play) { // main game execution cycle (replay loop)
            System.out.println("\nBy 1899, the age of outlaws and gunslingers was dying.");
            System.out.println("Two names crawl through the countryside like feverish rumors: O'Driscoll and Lemoyne Raider.");
            System.out.println("Both take what they want, but they do it for different reasons and by different codes.\n");
            System.out.println("Choose your path:");
            System.out.println("(1) O'Driscoll Boys — familial fury, grudges written in blood.");
            System.out.println("(2) Lemoyne Raiders — grand gestures, influence, and daring spectacle.");
            System.out.print("Choose your gang (1) O'Driscoll Boys (2) Lemoyne Raiders: ");

            int gang = 0;
            while (true) {
                if (sc.hasNextInt()) {
                    gang = sc.nextInt();
                    sc.nextLine();
                    if (gang == 1 || gang == 2) break;
                    System.out.print("Invalid — enter 1 for O'Driscoll or 2 for Lemoyne Raider: ");
                } else {
                    sc.nextLine();
                    System.out.print("Please enter 1 or 2: ");
                }
            }

            String[] inventory = new String[30];
            int invCount = 0;
            int courage = 5;
            boolean metLeader = false;
            boolean betrayed = false;
            boolean savedCivilians = false;
            boolean scarred = false;

            // Scene 1 — O'Driscoll / Raider selection and initiation
            if (gang == 1) {
                System.out.println("\nYou choose the O'Driscoll Boys — a clan of old resentments and fierce loyalties.");
                System.out.println("They like to keep to themselves, and their songs are mostly curses.");
                System.out.println("Broderick O'Driscoll, a weathered man who wears his family's history on his face, approaches you.\n");

                System.out.println("Scene 1 — Camp Initiation:");
                System.out.println("A cold wind sweeps across the camp. Men exchange glances and pass a single glass of whiskey around like a spoke of honor.");
                System.out.println("Broderick tests you: he offers a knife and a story of a homestead taken by lawmen and rival hands.");
                inventory[invCount++] = "knife";
                System.out.println("You accept the knife. It is less a tool and more an oath.\n");

                // Scene 2 — Retribution raid decision
                System.out.println("Scene 2 — Retribution on the Ridge:");
                System.out.println("Word reaches the O'Driscolls of a landowner who betrayed one of their kin years ago. Tonight, a small patrol gathers to fetch 'justice'.");
                System.out.println("Do you (1) join the retribution raid or (2) refuse and bide in the camp?");
                int choice1 = 0;
                while (choice1 != 1 && choice1 != 2) {
                    if (sc.hasNextInt()) {
                        choice1 = sc.nextInt();
                        sc.nextLine();
                        if (choice1 != 1 && choice1 != 2) System.out.print("Pick 1 or 2: ");
                    } else {
                        sc.nextLine();
                        System.out.print("Pick 1 or 2: ");
                    }
                }
                if (choice1 == 1) {
                    System.out.println("You ride under a blood-red moon. The raid is ugly but swift.");
                    courage += 1;
                    inventory[invCount++] = "stolen ledger";
                    System.out.println("The ledger you take whispers of town payments and crooked sheriffs.");
                } else {
                    System.out.println("You stay. The night stretches like a wound. Some respect your caution; others call you slow.");
                    courage -= 1;
                }

                // Scene 3 — Puzzle: locked chest at the homestead
                System.out.println("\nScene 3 — The Locked Chest at the Old Homestead:");
                System.out.println("An old chest sits beneath the floorboards of the burned homestead. A faded note hints: 'My three truths: 2 brothers, 7 fences, 9 winters.'");
                int[] combo = {2, 7, 9};
                int success = 0;
                System.out.println("You have three attempts to enter the three-digit combination.");
                for (int aTry = 1; aTry <= 3; aTry++) {
                    System.out.print("Attempt " + aTry + " — first digit: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Enter a number: ");
                    }
                    int d1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Second digit: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Enter a number: ");
                    }
                    int d2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Third digit: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Enter a number: ");
                    }
                    int d3 = sc.nextInt();
                    sc.nextLine();
                    if (d1 == combo[0] && d2 == combo[1] && d3 == combo[2]) {
                        System.out.println("The chest opens. Inside: an old family crest and a sawed-off shotgun.");
                        inventory[invCount++] = "family crest";
                        inventory[invCount++] = "sawed-off shotgun";
                        success = 1;
                        break;
                    } else {
                        System.out.println("The lock does not yield.");
                        if (aTry < 3) System.out.println("Try again.");
                    }
                }
                if (success == 0) {
                    System.out.println("You leave the chest sealed. Old things sometimes keep their peace.");
                }

                // Scene 4 — Roadside confrontation decision
                System.out.println("\nScene 4 — The Roadside Confrontation:");
                System.out.println("A small family is being harassed by bounty hunters at the town edge. The O'Driscoll code is twisted — protect kin, but strangers are expendable.");
                System.out.println("Do you (1) intervene to protect the family (win loyalty) or (2) ignore and focus on the clan's business?");
                int intervene = 0;
                while (intervene != 1 && intervene != 2) {
                    if (sc.hasNextInt()) {
                        intervene = sc.nextInt();
                        sc.nextLine();
                        if (intervene != 1 && intervene != 2) System.out.print("Choose 1 or 2: ");
                    } else {
                        sc.nextLine();
                        System.out.print("Choose 1 or 2: ");
                    }
                }
                if (intervene == 1) {
                    System.out.println("You fight and scare the bounty hunters off. The family swears to remember your name and owes you a favor.");
                    savedCivilians = true;
                    inventory[invCount++] = "family favor";
                    courage += 2;
                } else {
                    System.out.println("You ride on. The clan's needs weigh heavier than strangers' pleas.");
                    courage -= 2;
                }

                // Scene 5 — Broderick's offer decision
                System.out.println("\nScene 5 — Broderick's Offer:");
                System.out.println("Broderick arranges a risky strike on a corrupt coroner who shakes down O'Driscoll sympathizers. He asks if you'll lead the strike team.");
                System.out.println("Do you (1) lead the strike or (2) decline?");
                int lead = 0;
                while (lead != 1 && lead != 2) {
                    if (sc.hasNextInt()) {
                        lead = sc.nextInt();
                        sc.nextLine();
                        if (lead != 1 && lead != 2) System.out.print("1 or 2: ");
                    } else {
                        sc.nextLine();
                        System.out.print("1 or 2: ");
                    }
                }
                if (lead == 1) {
                    System.out.println("You accept. The plan is brutal and precise. Loyalty is currency, and you spend it freely.");
                    metLeader = true;
                    courage += 1;
                } else {
                    System.out.println("You decline. Some call you wise; others call you weak. Broderick files this away.");
                    courage -= 1;
                }

                // Scene 6 — The coroner's house strike
                System.out.println("\nScene 6 — The Coroner's House:");
                System.out.println("If you led the strike, things escalate. If not, your role is smaller but still dangerous.");
                if (lead == 1) {
                    boolean hasShotgun = false;
                    for (int i = 0; i < invCount; i++) {
                        if (inventory[i] != null && inventory[i].equals("sawed-off shotgun")) hasShotgun = true;
                    }
                    if (hasShotgun && courage > 5) {
                        System.out.println("You smash into the house and fight like a man possessed. The coroner is brought low, and incriminating papers are taken. The clan applauds.");
                    } else if (hasShotgun) {
                        System.out.println("You fight hard, but the hit costs lives. You survive, but the cost is a slow burn on your mind.");
                        scarred = true;
                    } else {
                        System.out.println("Without a proper weapon, the strike stumbles. The law moves faster than your plans; some of your crew are captured.");
                        betrayed = true;
                    }
                } else {
                    System.out.println("You observe from the trees and lend what you can. The results are mixed, but you retain a measure of safety and the bitterness of distance.");
                }

                // Scene 7 — After the fight aftermath
                System.out.println("\nScene 7 — After the Fight:");
                if (betrayed) {
                    System.out.println("You are arrested in the confusion or left to face a gang's wrath for failure. The O'Driscolls punish harshly for blunders.");
                } else {
                    if (savedCivilians) {
                        System.out.println("Those you helped whisper and make a way. A patched cloak or a meal can be lifesaving.");
                    } else {
                        System.out.println("Your name is one more notch on the O'Driscoll ledger — sometimes that is praise, sometimes a curse.");
                    }
                }

                // Scene 8 — Final choice and endings for O'Driscoll branch
                System.out.println("\nScene 8 — Final Choice:");
                System.out.println("(1) Lead a last, bloody strike to secure the clan's future.");
                System.out.println("(2) Betray the clan to the law in hopes of a lighter sentence.");
                System.out.println("(3) Disappear into the hills and try to earn a different name.");
                int finalChoice = 0;
                while (finalChoice < 1 || finalChoice > 3) {
                    if (sc.hasNextInt()) {
                        finalChoice = sc.nextInt();
                        sc.nextLine();
                        if (finalChoice < 1 || finalChoice > 3) System.out.print("Pick 1, 2, or 3: ");
                    } else {
                        sc.nextLine();
                        System.out.print("Pick 1, 2, or 3: ");
                    }
                }

                String ending = "undecided";
                if (finalChoice == 1) {
                    boolean hasShotgun = false;
                    for (int i = 0; i < invCount; i++) {
                        if (inventory[i] != null && inventory[i].equals("sawed-off shotgun")) hasShotgun = true;
                    }
                    if (hasShotgun && courage > 6) {
                        System.out.println("\nYou lead the strike, and the O'Driscolls carve a bloody legacy that ensures their survival a little longer.");
                        ending = "win";
                    } else if (courage >= 4) {
                        System.out.println("\nYou fight and you survive, but with scars — personal and historic.");
                        ending = "win";
                    } else {
                        System.out.println("\nThe strike fails. The O'Driscolls scatter and you are left to the mercy of men with laws.");
                        ending = "lose";
                    }
                } else if (finalChoice == 2) {
                    if (savedCivilians) {
                        System.out.println("\nYou give the law what they want. Because you once helped the innocent, someone speaks kindly of you; your sentence is lighter.");
                        ending = "alternative";
                    } else {
                        System.out.println("\nYou betray your kin for safety. No one honors such an act. You survive, but you will never sleep easy.");
                        ending = "lose";
                    }
                } else {
                    boolean hasFamilyCrest = false;
                    for (int i = 0; i < invCount; i++) {
                        if (inventory[i] != null && inventory[i].equals("family crest")) hasFamilyCrest = true;
                    }
                    if (hasFamilyCrest && courage >= 4) {
                        System.out.println("\nYou slip away with the family crest tucked under your shirt. You vanish into the mountains and build a different life.");
                        ending = "secret";
                    } else if (scarred) {
                        System.out.println("\nYou leave with wounds and memories. You find a quiet farm and fade gently into anonymity.");
                        ending = "alternative";
                    } else {
                        System.out.println("\nYou try to leave, but the clan does not forgive running. They find you, and you pay for what you were, not what you hoped to be.");
                        ending = "lose";
                    }
                }

                if (ending.equals("win")) {
                    System.out.println("\nENDING: O'Driscoll — A temporary victory, blood-bound and honored among kin.");
                } else if (ending.equals("lose")) {
                    System.out.println("\nENDING: O'Driscoll — Defeat, capture, or death. A hard lesson for those who trusted violence as a future.");
                } else if (ending.equals("secret")) {
                    System.out.println("\nENDING: O'Driscoll — Secret — You live under a new name, the old life a weight you put down.");
                } else {
                    System.out.println("\nENDING: O'Driscoll — Alternative — Survival without honor.");
                }

                System.out.println("\nInventory:");
                if (invCount == 0) System.out.println("- (empty)");
                else for (int i = 0; i < invCount; i++) System.out.println("- " + inventory[i]);
            }

            // Scene 1 — Lemoyne Raiders initiation and path
            else {
                System.out.println("\nYou choose the Lemoyne Raiders — dramatists of the frontier and predators with panache.");
                System.out.println("Madam Rousseau grins, drapes a map over your shoulder, and pours you a dram.\n");
                inventory[invCount++] = "map";
                inventory[invCount++] = "brandy";

                System.out.println("Scene 1 — A Night of Masks:");
                System.out.println("The Raiders hold a makeshift gala beneath Spanish moss. Theatrics are currency here — the louder your story, the more you are worth.");
                System.out.println("Madam Rousseau offers you a small role in a planned spectacle that will embarrass a local magistrate. Participation means prestige.");
                System.out.println("Do you (1) play your part in the spectacle or (2) stay in the wings?");
                int playPart = 0;
                while (playPart != 1 && playPart != 2) {
                    if (sc.hasNextInt()) {
                        playPart = sc.nextInt();
                        sc.nextLine();
                        if (playPart != 1 && playPart != 2) System.out.print("1 or 2: ");
                    } else {
                        sc.nextLine();
                        System.out.print("1 or 2: ");
                    }
                }
                if (playPart == 1) {
                    System.out.println("You perform a daring stunt that shames the magistrate. The crowd roars. Your name grows loud and bright.");
                    courage += 1;
                    inventory[invCount++] = "raider's token";
                } else {
                    System.out.println("You observe. You learn how the Raiders use theater to manipulate crowds and politicians.");
                    courage -= 1;
                }

                // Scene 2 — Riverfolk favor and decision to heist or extort
                System.out.println("\nScene 2 — A Favor from the Riverfolk:");
                System.out.println("A river captain owes the Raiders a favor. He hints at a shipment of silver moving through a nearby port. It's an opportunity to both steal and send a message.");
                System.out.println("Do you (1) plan a heist on the shipment or (2) broker a deal to extort the captain for influence?");
                int riverChoice = 0;
                while (riverChoice != 1 && riverChoice != 2) {
                    if (sc.hasNextInt()) {
                        riverChoice = sc.nextInt();
                        sc.nextLine();
                        if (riverChoice != 1 && riverChoice != 2) System.out.print("1 or 2: ");
                    } else {
                        sc.nextLine();
                        System.out.print("1 or 2: ");
                    }
                }
                if (riverChoice == 1) {
                    System.out.println("You plan and scout. Nights of plotted signals and quiet oars. A heist needs precision, and the Raiders have a taste for spectacle even in theft.");
                    inventory[invCount++] = "raider's rope";
                    courage += 1;
                } else {
                    System.out.println("You meet the captain quietly and make a claim. You trade threats for protection; power is sometimes bought rather than taken.");
                    inventory[invCount++] = "captain's favor";
                }

                // Scene 3 — Puzzle: theater lockbox
                System.out.println("\nScene 3 — The Theater Lockbox:");
                System.out.println("Backstage, a small lockbox holds the Raiders' ledger and a key to influence. The lock is three digits and the stage's banners list three numbers, but in riddled order.");
                int[] raiderCombo = {5, 2, 8};
                int solved = 0;
                System.out.println("You have three attempts to match the box's combination.");
                for (int attempt = 1; attempt <= 3; attempt++) {
                    System.out.print("Attempt " + attempt + " — first digit: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Enter a number: ");
                    }
                    int r1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Second digit: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Enter a number: ");
                    }
                    int r2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Third digit: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Enter a number: ");
                    }
                    int r3 = sc.nextInt();
                    sc.nextLine();
                    if (r1 == raiderCombo[0] && r2 == raiderCombo[1] && r3 == raiderCombo[2]) {
                        System.out.println("The box swings open. Inside: a ledger with names, a small pistol, and an invitation to a masquerade.");
                        inventory[invCount++] = "ledger";
                        inventory[invCount++] = "pocket pistol";
                        inventory[invCount++] = "masquerade invite";
                        solved = 1;
                        break;
                    } else {
                        System.out.println("The lock stays quiet, smug as a judge.");
                        if (attempt < 3) System.out.println("Try to reorder the memories of the stage.");
                    }
                }
                if (solved == 0) {
                    System.out.println("You leave the box closed. Some secrets like their silence.");
                }

                // Scene 4 — Public scandal decision
                System.out.println("\nScene 4 — A Public Scandal:");
                System.out.println("A merchant is being shamed publicly. The Raiders could turn it into a grand mockery that both humiliates an enemy and draws crowds — or quietly help the merchant and win a grateful ally.");
                System.out.println("Do you (1) turn the situation into spectacle or (2) help the merchant discreetly?");
                int raiderIntervene = 0;
                while (raiderIntervene != 1 && raiderIntervene != 2) {
                    if (sc.hasNextInt()) {
                        raiderIntervene = sc.nextInt();
                        sc.nextLine();
                        if (raiderIntervene != 1 && raiderIntervene != 2) System.out.print("1 or 2: ");
                    } else {
                        sc.nextLine();
                        System.out.print("1 or 2: ");
                    }
                }
                if (raiderIntervene == 1) {
                    System.out.println("You turn it into a roaring scene. The crowd laughs; the merchant's ruin becomes your theater. You gain fame and notoriety.");
                    inventory[invCount++] = "public notoriety";
                    courage += 2;
                } else {
                    System.out.println("You pull the merchant aside and help in silence. He offers a quiet coin and a favor for later.");
                    inventory[invCount++] = "merchant's gratitude";
                    savedCivilians = true;
                    courage -= 1;
                }

                // Scene 5 — Madame Rousseau's proposition decision
                System.out.println("\nScene 5 — Madame Rousseau's Proposition:");
                System.out.println("Rousseau invites you to a private séance of influence. The plan: bribe, blackmail, or charm a judge into turning a blind eye on Raider activities.");
                System.out.println("Do you (1) participate in the influence operation or (2) refuse and maintain your independent streak?");
                int rousseauChoice = 0;
                while (rousseauChoice != 1 && rousseauChoice != 2) {
                    if (sc.hasNextInt()) {
                        rousseauChoice = sc.nextInt();
                        sc.nextLine();
                        if (rousseauChoice != 1 && rousseauChoice != 2) System.out.print("1 or 2: ");
                    } else {
                        sc.nextLine();
                        System.out.print("1 or 2: ");
                    }
                }
                if (rousseauChoice == 1) {
                    System.out.println("You sign on. The Raiders weave influence quietly and the magistrate begins to miss inconvenient notes.");
                    metLeader = true;
                    courage += 1;
                } else {
                    System.out.println("You refuse. Rousseau watches you with the expression of someone who counts all losses and all gains.");
                    courage -= 1;
                }

                // Scene 6 — Consequences of heist or extortion
                System.out.println("\nScene 6 — Consequences of Influence:");
                if (riverChoice == 1) {
                    System.out.println("You lead or assist in the heist on the silver shipment. The glitter of success is loud and the Raiders' name grows in the papers.");
                    if (solved == 1 && courage > 5) {
                        System.out.println("The heist is executed with flair. The ledger shows the merchant's secret payoffs — leverage for future moves.");
                    } else if (solved == 1) {
                        System.out.println("You pull off the job but at personal cost. Someone recognizes you in the lantern light.");
                        scarred = true;
                    } else {
                        System.out.println("The heist breaks down; the plan lacked a missing piece and lawmen arrive faster than applause.");
                        betrayed = true;
                    }
                } else {
                    System.out.println("You took a calmer route by extortion. Influence and threats buy favors, but the results are slower and less dramatic.");
                }

                // Scene 7 — After the curtain falls
                System.out.println("\nScene 7 — After the Curtain Falls:");
                if (betrayed) {
                    System.out.println("Officials close in and some Raiders get arrested. The Raiders' flamboyance cannot always hide mistakes.");
                } else {
                    if (savedCivilians) {
                        System.out.println("You are quietly rewarded by those you helped. Influence is sometimes born of kindness.");
                    } else {
                        System.out.println("Your name is either sung by drunkards or used as a threat — depending on who hears it.");
                    }
                }

                // Scene 8 — Final gambit and endings for Raiders
                System.out.println("\nScene 8 — Final Gambit:");
                System.out.println("(1) Stage the Raiders' biggest show — a public strike that will make or break the group.");
                System.out.println("(2) Cut a deal with the magistrate: sell out a secret to buy safety and favors.");
                System.out.println("(3) Use the ledger and vanish into politics: take a new name and a seat of small power.");
                int finalChoiceR = 0;
                while (finalChoiceR < 1 || finalChoiceR > 3) {
                    if (sc.hasNextInt()) {
                        finalChoiceR = sc.nextInt();
                        sc.nextLine();
                        if (finalChoiceR < 1 || finalChoiceR > 3) System.out.print("Pick 1, 2, or 3: ");
                    } else {
                        sc.nextLine();
                        System.out.print("Pick 1, 2, or 3: ");
                    }
                }

                String endingR;
                boolean hasLedger = false;
                boolean hasPistol = false;
                for (int i = 0; i < invCount; i++) {
                    if (inventory[i] != null && inventory[i].equals("ledger")) hasLedger = true;
                    if (inventory[i] != null && inventory[i].equals("pocket pistol")) hasPistol = true;
                }

                if (finalChoiceR == 1) {
                    if (metLeader && courage > 6 && hasPistol) {
                        System.out.println("\nYou stage a brilliant public strike. The Raiders become a legend; you bask in the spotlight.");
                        endingR = "win";
                    } else if (courage >= 4) {
                        System.out.println("\nThe spectacle succeeds in part; you survive but the price is high in friends and reputation.");
                        endingR = "win";
                    } else {
                        System.out.println("\nThe show collapses. Law closes in. The Raiders disperse with broken pride.");
                        endingR = "lose";
                    }
                } else if (finalChoiceR == 2) {
                    if (hasLedger) {
                        System.out.println("\nYou trade the ledger for protection. The magistrate smiles and hides your part in exchange for secrets.");
                        endingR = "alternative";
                    } else {
                        System.out.println("\nYou try to bargain without leverage and are instead cornered. Deals require goods; you have none to give.");
                        endingR = "lose";
                    }
                } else {
                    if (hasLedger && courage >= 4) {
                        System.out.println("\nYou use the ledger to push into softer power — bribery, influence, and eventually a polite seat at a small table.");
                        endingR = "secret";
                    } else if (savedCivilians) {
                        System.out.println("\nYou step away quietly, aided by those you helped. A new life that looks like living rather than legend.");
                        endingR = "alternative";
                    } else {
                        System.out.println("\nYou attempt to vanish but the theater of your life keeps following you; the Raiders do not forgive ghosts easily.");
                        endingR = "lose";
                    }
                }

                if (endingR.equals("win")) {
                    System.out.println("\nENDING: Lemoyne Raiders — Success in spectacle, your name on the lips of revelers.");
                } else if (endingR.equals("lose")) {
                    System.out.println("\nENDING: Lemoyne Raiders — Failure and scatter; theatrical men without an audience.");
                } else if (endingR.equals("secret")) {
                    System.out.println("\nENDING: Lemoyne Raiders — Secret — You enter the halls of quiet power; substituted fame for influence.");
                } else {
                    System.out.println("\nENDING: Lemoyne Raiders — Alternative — survival with compromises.");
                }

                System.out.println("\nInventory:");
                if (invCount == 0) System.out.println("- (empty)");
                else for (int i = 0; i < invCount; i++) System.out.println("- " + inventory[i]);
            }
            
            System.out.println("\nWould you like to play again? (y/n): ");
            String again = "";
            while (true) {
                again = sc.nextLine().trim().toLowerCase();
                if (again.equals("y") || again.equals("n")) break;
                System.out.print("Please enter 'y' or 'n': ");
            }
            if (again.equals("n")) {
                play = false;
                System.out.println("\nThanks for playing. Farewell, outlaw.");
            } else {
                System.out.println("\nStarting a new tale...");
            }
        }
    }
}