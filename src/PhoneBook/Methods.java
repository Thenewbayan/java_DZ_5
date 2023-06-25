package PhoneBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


// 1)Реализуйте структуру телефонной книги с помощью HashMap. Программа также должна учитывать, 
// что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, 
// как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
// (можно выводить без сортировки, но обязательно в отдельном методе)
public class Methods {

    public static class PhoneBook {
        private Map<String, Set<String>> phoneBook;
    
        public PhoneBook() {
            phoneBook = new HashMap<>();
        }
    
        public void addContact(String name, String phone) {
            Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    
        public void printPhoneBook() {
            List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
            Collections.sort(entries, (e1, e2) -> e2.getValue().size() - e1.getValue().size());
            for (Map.Entry<String, Set<String>> entry : entries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
