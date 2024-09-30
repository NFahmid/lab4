import java.util.*;

public class Statement_Handler {
    private List<Statement> transactions;

    public Statement_Handler() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Statement transaction) {
        transactions.add(transaction);
    }

    public double calculateTotalProfitOrLoss() {
        double total = 0;
        for (Statement transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    public int countTransactionsByMonth(String month) {
        int count = 0;
        for (Statement transaction : transactions) {
            if (transaction.getDate().contains(month)) {
                count++;
            }
        }
        return count;
    }

    public List<Statement> getTop10Expenses() {
        List<Statement> expenses = new ArrayList<>();
        for (Statement transaction : transactions) {
            if (transaction.getAmount() < 0) {
                expenses.add(transaction);
            }
        }

        expenses.sort(Comparator.comparingDouble(Statement::getAmount));

        return expenses.size() > 10 ? expenses.subList(0, 10) : expenses;
    }

//    public String getMostSpentCategory() {
//    }

}
