package TelegramBot.bot;

import java.util.*;

public class Leaderboard {
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    public static String leaderboardMessage(Map<String, Integer> leaderboard){
        Map<String, Integer> sortedLeaderboard = sortByValue(leaderboard);
        Set<String> setSortedLeaderboard = sortedLeaderboard.keySet();

        List<String> reverse = new ArrayList<>();
        reverse.addAll(setSortedLeaderboard);
        Collections.reverse(reverse);

        String message = "Таблица лидеров по мощи армии:\n";
        Iterator<String> leaderboardIterator = reverse.iterator();
        Integer i = 1;
        while(leaderboardIterator.hasNext()){
            String next = leaderboardIterator.next();
            String m = String.format("%s    %s     %s\n",i, next, sortedLeaderboard.get(next));
            message = message + m;
            i++;
        }
        return message;
    }
}