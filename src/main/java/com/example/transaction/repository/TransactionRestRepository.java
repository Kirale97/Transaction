package com.example.transaction.repository;

import com.example.transaction.model.Transaction;
import com.example.transaction.model.statics.FilesManager;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TransactionRestRepository {

    public int addTransaction(Transaction transaction){
     return FilesManager.writeToFile("transactionList.txt" , transaction.write() );
    }
    public int deleteTransaction(long id){
        List<Transaction> list = readTransaction();
        Optional<Transaction> tmp = list.stream().filter(transaction -> transaction.getId() == id).findFirst();
        if(tmp.isEmpty())
            return 1;
        list.remove(tmp.get());
        //eliminazione file
        File file = new File("transactionList.txt");
        file.delete();
        //fine eliminazione file
        list.stream().forEach(transaction -> addTransaction(transaction));
        return 0;
    }
    private List<Transaction> modifyTransaction(long id){
        List<Transaction> list = readTransaction();
        Optional<Transaction> tmp = list.stream().filter(transaction -> transaction.getId() == id).findFirst();
        if(tmp.isEmpty())
            return null;
        return list;
    }
    public int modifyTransactionName (long id, String name){
        List<Transaction> list = modifyTransaction(id);
        list.stream().filter(transaction -> transaction.getId() == id).forEach(transaction -> transaction.setName(name));
        modifyTransaction2(id, list);
        return 0;
    }
    public int modifyTransactionDescription (long id, String description){
        List<Transaction> list = modifyTransaction(id);
        list.stream().filter(transaction -> transaction.getId() == id).forEach(transaction -> transaction.setDescription(description));
        modifyTransaction2(id, list);
        return 0;
    }
    public int modifyTransactionAmount (long id, Double amount){
        List<Transaction> list = modifyTransaction(id);
        list.stream().filter(transaction -> transaction.getId() == id).forEach(transaction -> transaction.setAmount(amount));
        modifyTransaction2(id, list);
        return 0;
    }
    public int modifyTransactionDate (long id, LocalDate date){
        List<Transaction> list = modifyTransaction(id);
        list.stream().filter(transaction -> transaction.getId() == id).forEach(transaction -> transaction.setDate(date));
        modifyTransaction2(id, list);
        return 0;
    }
    private int modifyTransaction2 (long id, List<Transaction> list){
        //eliminazione file
        File file = new File("transactionList.txt");
        file.delete();
        //fine eliminazione file
        list.stream().forEach(transaction -> addTransaction(transaction));
        return 0;
    }
    public List<Transaction>  readTransaction(){
        List<Transaction> transactionList = new ArrayList<>();
        List<String> rows = new ArrayList<>();
        rows = FilesManager.readFromFile("transactionList.txt");
        if (rows !=null && rows.size() !=0){
            rows.stream().forEach(row->
            {
                String[] s1 = row.split("/");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                transactionList.add(new Transaction(Long.parseLong(s1[0]), s1[1], s1[2], Double.parseDouble(s1[3]), LocalDate.parse(s1[4], formatter) ));
            });

        }
        return transactionList;
    }
    /*
     add/mod/del cat(del budget as well)
     add/mod/del bud
     get trans day/week/month/year
     get lastTrans

     */
}
