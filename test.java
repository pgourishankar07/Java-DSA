public class test {

    public static void main(String[] args) {
        String s = "IamLoveInWithYou";
        boolean flag = true;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            str.append(c);
            if (c >= 'A' && c <= 'Z') {
                if (flag) {
                    flag = false;
                    continue;
                } else {
                    str.deleteCharAt(str.length() - 1);
                }
                System.out.println(str);
                str.setLength(0);
                str.append(c);
            }
        }
        System.out.println(str);

    }

}