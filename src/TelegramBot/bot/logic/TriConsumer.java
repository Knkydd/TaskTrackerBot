package TelegramBot.bot.logic;

public interface TriConsumer<T, U, V> {
    void accept(T t, U u, V v);
}
