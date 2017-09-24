def dictionary = new TreeSet()
new File('dictionary.txt').eachLine { line ->
    dictionary << line
}

def maxWordLength = 4
Set<String> allCombinations = find("ctelgae", maxWordLength)

allCombinations.findAll{it.length() != 1 && it.length() == maxWordLength  && dictionary.contains(it)}.forEach{ println it }

static Set<String> find(String s, int maxLength) {
    Set<String> ss = new HashSet<String>()
    if (s == null) {
        return null
    }
    if (s.length() == 0) {
        ss.add("")
    } else {
        char c = s.charAt(0);
        String st = s.substring(1);
        Set<String> qq = find(st, maxLength)
        for (String str : qq) {
            if (str.length() <= maxLength - 1) {
                for (int i = 0; i <= str.length(); i++) {
                    def word = comb(str, c, i)
                        ss.add(word)
                }
                ss.add("" + c)
                ss.add(str)
            } else if (str.length() == maxLength) {
                ss.add(str)
            }
        }
    }
    return ss
}

static String comb(String s, char c, int i) {
    String start = s.substring(0, i)
    String end = s.substring(i)
    return start + c + end
}

