class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        PeopleStats peopleStats = new PeopleStats(Paths.get("śćieżka", "do", "pliku"));

        System.out.println(String.format("Liczba osób: %d", peopleStats.count()));

        PeopleStats peopleStats = new PeopleStats(Paths.get("śćieżka", "do", "pliku"));

        System.out.println(String.format("Liczba osób: %d", peopleStats.count()));
        System.out.println(String.format("Liczba osób z unikalnymi nazwiskami: %d", peopleStats.countUniqueLastNames()));
    }
}


class PeopleStats {
    private final List<Person> people;

    public PeopleStats(Path inputFilePath) {
        try {
            people = Files.lines(inputFilePath)
                    .map(line -> line.split("\t"))
                    .map(chunks -> new Person(chunks[0], chunks[1]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public long count() {
        return people.size();
    }

    public long countUniqueLastNames() {
        return people.stream()
                .map(Person::getLastName)
                .distinct()
                .count();
    }
}

class Person {
    private final String firstName;
    private final String last
    Name;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLast() {
        return last;
    }

    public Person(String firstName, String last) {
        this.firstName = firstName;
        this.last = last;
    }
}