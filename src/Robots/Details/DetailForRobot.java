package Robots.Details;

public abstract class DetailForRobot {
    public abstract DetailName getDetailName();
    private String serNo;

    public String getSerNo() {
        return serNo;
    }

    public void setSerNo(String serNo) {
        this.serNo = serNo;
    }

    @Override
    public int hashCode() {
        return getSumOfChars(this.getDetailName().getDescription());
    }

    @Override
    public boolean equals(Object obj) {
        DetailForRobot detail = (DetailForRobot) obj;
        if (this.getDetailName().getDescription().equals(detail.getDetailName().getDescription())) {
            return true;
        }
        return false;
    }

    public int getSumOfChars(String analysedString) {
        char[] charArrayr = analysedString.toCharArray();
        int amount = 0;
        for (char ch : charArrayr) {
            amount += (int) ch;
        }
        return amount;
    }
}
