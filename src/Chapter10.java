import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {
    public static void main(String[] args) throws Exception {
        List<Task> list = new ArrayList<>();
        list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
        list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
        list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
        list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
        list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

        // 以下記述
        //未完了タスク数
        long falseCount = 0;
        
        falseCount = list.stream() //Streamの生成
        	.filter(f -> f.isDone() == false) //未完了を抽出
        	.count(); //未完了のタスクの数を返す
        System.out.println("未完了のタスクの個数は" + falseCount);
        
        System.out.println("【未完了のタスクを昇順に並び替えて一覧表示");
        
        list.stream() //Streamの生成
        	.filter(f -> f.isDone() == false) //未完了のタスクを抽出
        	.sorted((f1, f2) -> f1.compareTo(f2)) //日付で並び替える
        	.forEach(System.out::println); //並び替えたあとに個別に表示する
        
    }
}