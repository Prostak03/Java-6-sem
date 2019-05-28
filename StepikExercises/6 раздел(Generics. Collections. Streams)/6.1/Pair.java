import java.util.Objects;
import java.util.Optional;

class Pair<X,T> {
    private Optional<X> first;
    private Optional<T> second;

    private Pair(X first, T second) {
        this.first =  Optional.ofNullable(first);
        this.second = Optional.ofNullable( second);
    }

    public static <X,T> Pair<X,T> of(X first,T second){
        return new Pair<>(first, second);
    }

    public X getFirst(){
        return first.orElse(null);
    }

    public T getSecond(){
        return second.orElse(null);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair<?,?> other = (Pair<?,?>) obj;
        return Objects.equals(first.orElse(null),other.getFirst()) && Objects.equals(second.orElse(null),other.getSecond());
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * Objects.hashCode(first) + Objects.hashCode(second);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
