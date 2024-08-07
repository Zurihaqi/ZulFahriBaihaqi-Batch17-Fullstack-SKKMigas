import java.util.*;

public class PengelompokanHuruf {
    public static void main(String[] args) {
        String[] case1 = {"Oke", "One"}; // Expected output: "Oekn"
        String[] case2 = {"Abc", "bCd"}; // Expected output: "bACcd"
        String[] case3 = {
                "Pendanaan",
                "Terproteksi",
                "Untuk",
                "Dampak",
                "Berarti"
        }; // Expected output: "aenrktipBDPTUdmosu"

        System.out.println(kelompokan(case1));
        System.out.println(kelompokan(case2));
        System.out.println(kelompokan(case3));
    }

    public static String kelompokan(String[] strArr) {
        Map<Character, Integer> unsortedMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        // Map kemunculan setiap char dari string
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                // key i = compared char, key j = comparator char
                // Jika i belum pernah muncul maka value = 1
                if (!unsortedMap.containsKey(strArr[i].charAt(j))) {
                    unsortedMap.put(strArr[i].charAt(j), 1);
                } else {
                    // Jika i muncul lebih dari 1, value + 1
                    unsortedMap.put(strArr[i].charAt(j), unsortedMap.get(strArr[i].charAt(j)) + 1);
                }
            }
        }

        // Membuat ArrayList baru yang berisi entrySet dari unsortedMap agar bisa menggunakan method.sort()
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(unsortedMap.entrySet());

        sortedList.sort((a, b) -> {
            int frequency = b.getValue() - a.getValue();
            if(frequency != 0){
                // Jika frekuensi berbeda, urutkan berdasarkan frekuensi
                return frequency;
            } else {
                // Jika frekuensi sama, urutkan berdasarkan urutan karakter
                return Character.compare(a.getKey(), b.getKey());
            }
        });

        // Masukan karakter yang telah diurut ke dalam result
        for(Map.Entry<Character, Integer> entry : sortedList) {
            result.append(entry.getKey());
        }

        return result.toString();
    }
}
