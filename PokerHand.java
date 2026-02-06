public class PokerHand {
    public int[] cardsInHand;
    public int bidValue;
    public int handPowerType;
    public int handPowerCard;

    public PokerHand(int[] hand, int bidValue, int handPowerCard, int handPowerType){
        cardsInHand = hand;
        this.bidValue = bidValue;
        this.handPowerCard = handPowerCard;
        this.handPowerType = handPowerType;
    }
    public PokerHand(){
        cardsInHand = new int[5];
        this.bidValue = 0;
        this.handPowerCard = 0;
        this.handPowerType = 0;
    }


    public int[] getCardsInHand() {
        return cardsInHand;
    }

    public int getBidValue() {
        return bidValue;
    }

    public int getHandPowerType() {
        return handPowerType;
    }

    public int getHandPowerCard() {
        return handPowerCard;
    }

    public void setCardsInHand(int index, int cardSet) {
        cardsInHand[index] = cardSet;
    }

    public void setBidValue(int bidValue) {
        this.bidValue = bidValue;
    }

    public void setHandPowerType(int handPowerType) {
        this.handPowerType = handPowerType;
    }

    public void setHandPowerCard(int handPowerCard) {
        this.handPowerCard = handPowerCard;
    }
}
