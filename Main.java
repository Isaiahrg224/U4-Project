import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        int amountOfFiveOfAKind = 0;
        int amountOfFourOfAKind = 0;
        int amountOfFullHouse = 0;
        int amountOfThreeOfAKind = 0;
        int amountOfTwoPair = 0;
        int amountOfPair = 0;
        int amountOfHighCard = 0;
        String[] lines = fileData.split("\n");
        PokerHand[] pokerHands = new PokerHand[lines.length];
        for (String line : lines) {
            PokerHand currentHand = new PokerHand();
            String[] hands = line.split("[,|]");
            int[] handsToNumbers = new int[hands.length + 2];
            for (int i = 0; i < hands.length; i++) {

                if (hands[i].equals("Jack")) {
                    handsToNumbers[i] = 11;
                } else if (hands[i].equals("Queen")) {
                    handsToNumbers[i] = 12;
                } else if (hands[i].equals("King")) {
                    handsToNumbers[i] = 13;
                } else if (hands[i].equals("Ace")) {
                    handsToNumbers[i] = 14;
                } else {
                    handsToNumbers[i] = Integer.parseInt(hands[i]);
                }
                currentHand.setCardsInHand(i, handsToNumbers[i]);
            }
            currentHand.setBidValue(handsToNumbers[5]);
                boolean fiveOfAKind = true;
                boolean fourOfAKind = true;
                boolean threeOfAKind = true;
                int amountOfPairs = 0;

                for (int z = 0; z < hands.length - 1; z++) {
                    if (!(handsToNumbers[0] == handsToNumbers[z])) {
                        fiveOfAKind = false;
                    }
                }
                if(fiveOfAKind){
                    handsToNumbers[7] = handsToNumbers[0];
                }

                int amountOfSameCards1 = 0;
                int amountOfSameCards2 = 0;
                for (int z = 0; z < hands.length - 1; z++) {
                    if ((handsToNumbers[0] == handsToNumbers[z])) {
                        amountOfSameCards1++;
                    }
                    if ((handsToNumbers[1] == handsToNumbers[z])) {
                        amountOfSameCards2++;
                    }
                }
                if (!(amountOfSameCards1 == 4 || amountOfSameCards2 == 4)) {
                    fourOfAKind = false;
                }
                if(fourOfAKind && handsToNumbers[7] == 0){
                    if(amountOfSameCards1 == 4){
                    handsToNumbers[7] = handsToNumbers[0];
                }
                    if(amountOfSameCards2 == 4){
                        handsToNumbers[7] = handsToNumbers[1];
                }
                }

                amountOfSameCards1 = 0;
                amountOfSameCards2 = 0;
                int amountOfSameCards3 = 0;
                for (int z = 0; z < hands.length - 1; z++) {
                    if ((handsToNumbers[0] == handsToNumbers[z])) {
                        amountOfSameCards1++;
                    }
                    if ((handsToNumbers[1] == handsToNumbers[z])) {
                        amountOfSameCards2++;
                    }
                    if ((handsToNumbers[2] == handsToNumbers[z])) {
                        amountOfSameCards3++;
                    }
                }
                if (!(amountOfSameCards1 == 3 || amountOfSameCards2 == 3 || amountOfSameCards3 == 3)) {
                    threeOfAKind = false;
                }
                if(threeOfAKind && handsToNumbers[7] == 0){
                    if(amountOfSameCards1 == 3){
                    handsToNumbers[7] = handsToNumbers[0];
                }
                    if(amountOfSameCards2 == 3){
                    handsToNumbers[7] = handsToNumbers[1];
                }
                    if(amountOfSameCards3 == 3){
                    handsToNumbers[7] = handsToNumbers[2];
                }
            }
                amountOfSameCards1 = 0;
                amountOfSameCards2 = 0;
                amountOfSameCards3 = 0;
                int amountOfSameCards4 = 0;
                int amountOfSameCards5 = 0;
                for (int z = 0; z < hands.length - 1; z++) {
                    if ((handsToNumbers[0] == handsToNumbers[z])) {
                        amountOfSameCards1++;
                    }
                    if ((handsToNumbers[1] == handsToNumbers[z])) {
                        amountOfSameCards2++;
                    }
                    if ((handsToNumbers[2] == handsToNumbers[z])) {
                        amountOfSameCards3++;
                    }
                    if ((handsToNumbers[3] == handsToNumbers[z])) {
                        amountOfSameCards4++;
                    }
                    if ((handsToNumbers[4] == handsToNumbers[z])) {
                        amountOfSameCards5++;
                    }
                }
                boolean fullHousePossibile = false;
                    if ((amountOfSameCards1 + amountOfSameCards2 + amountOfSameCards3 + amountOfSameCards4 +
                        amountOfSameCards5 == 7)) {
                        amountOfPairs = 1;
            }
                    if ((amountOfSameCards1 + amountOfSameCards2 + amountOfSameCards3 + amountOfSameCards4 +
                        amountOfSameCards5 == 9)) {
                        amountOfPairs = 2;
            }
                    if ((amountOfSameCards1 + amountOfSameCards2 + amountOfSameCards3 + amountOfSameCards4 +
                        amountOfSameCards5 == 13)){
                        fullHousePossibile = true;
            }
                    if(amountOfPairs >= 1 && handsToNumbers[7] == 0){
                        if(amountOfSameCards1 == 2){
                    handsToNumbers[7] = handsToNumbers[0];
                }
                    if(amountOfSameCards2 == 2 && handsToNumbers[1] > handsToNumbers[7]){
                    handsToNumbers[7] = handsToNumbers[1];
                }
                    if(amountOfSameCards3 == 2 && handsToNumbers[2] > handsToNumbers[7]){
                    handsToNumbers[7] = handsToNumbers[2];
                }
                    if(amountOfSameCards4 == 2 &&  handsToNumbers[3] > handsToNumbers[7]){
                        handsToNumbers[7] = handsToNumbers[3];
                    }
                    if(amountOfSameCards5 == 2 &&  handsToNumbers[4] > handsToNumbers[7]){
                        handsToNumbers[7] = handsToNumbers[4];
                    }
            }
                    if(handsToNumbers[7] == 0){
                        int highCard = 0;
                        for(int q = 0; q < 5; q++){
                            if(handsToNumbers[q] > highCard){
                                highCard = handsToNumbers[q];
                            }
                        }
                        handsToNumbers[7] = highCard;
                    }

                if(fiveOfAKind){
                    handsToNumbers[6] = 6;
                    amountOfFiveOfAKind++;
                }
                else if(fourOfAKind){
                    handsToNumbers[6] = 5;
                    amountOfFourOfAKind++;
                }
                else if(threeOfAKind && fullHousePossibile){
                    handsToNumbers[6] = 4;
                    amountOfFullHouse++;
                }
                else if(threeOfAKind){
                    handsToNumbers[6] = 3;
                    amountOfThreeOfAKind++;
                }
                else if(amountOfPairs == 2){
                    handsToNumbers[6] = 2;
                    amountOfTwoPair++;
                }
                else if(amountOfPairs == 1){
                    handsToNumbers[6] = 1;
                    amountOfPair++;
                }
                else{
                    handsToNumbers[6] = 0;
                    amountOfHighCard++;
                }

                currentHand.setHandPowerType(handsToNumbers[6]);
                currentHand.setHandPowerCard(handsToNumbers[7]);
                System.out.println(Arrays.toString(handsToNumbers));
        }
//        int[] currentMinumimHand = new int[2];
//        currentMinumimHand[0] = 0;
//        currentMinumimHand[1] = 0;
//        for(int handPower = 1; handPower < lines.length + 1; handPower++){
//            for(int handNumber = 0; handNumber < lines.length; handNumber++ ){
//                if();
        //}
        //}
        System.out.println("Number of five of a kind hands: " + amountOfFiveOfAKind);
        System.out.println("Number of four of a kind hands: " + amountOfFourOfAKind);
        System.out.println("Number of full house hands: " + amountOfFullHouse);
        System.out.println("Number of three of a kind hands: " + amountOfThreeOfAKind);
        System.out.println("Number of two pair hands: " + amountOfTwoPair);
        System.out.println("Number of one pair hands: " + amountOfPair);
        System.out.println("Number of high card hands: " + amountOfHighCard);
    }
}

