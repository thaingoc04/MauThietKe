public class Adapter {
    // Giao diện cho ngôn ngữ tiếng Việt
    public interface VietnameseLanguage {
        String speakVietnamese();
    }

    // Giao diện cho ngôn ngữ tiếng Nhật
    public interface JapaneseLanguage {
        String speakJapanese();
    }

    public static class VietnameseSpeaker implements VietnameseLanguage {
        @Override
        public String speakVietnamese() {
            return "Xin chào!";
        }
    }

    public static class VietnameseToJapaneseAdapter implements JapaneseLanguage {
        private VietnameseLanguage vietnameseSpeaker;

        public VietnameseToJapaneseAdapter(VietnameseLanguage vietnameseSpeaker) {
            this.vietnameseSpeaker = vietnameseSpeaker;
        }

        @Override
        public String speakJapanese() {
            String vietnamese = vietnameseSpeaker.speakVietnamese();
            // Thực hiện chuyển đổi ngôn ngữ từ tiếng Việt sang tiếng Nhật
            String japanese = convertVietnameseToJapanese(vietnamese);
            return japanese;
        }

        private String convertVietnameseToJapanese(String vietnamese) {
            // Thực hiện việc chuyển đổi ngôn ngữ tại đây (đây chỉ là ví dụ đơn giản)
            // Thông thường, bạn sẽ cần một hệ thống dịch hoặc một logic phức tạp hơn.
            return "Japanese: こんにちは! ";
        }
    }

    public static void main(String[] args) {
        VietnameseLanguage vietnamesePerson = new VietnameseSpeaker();
        JapaneseLanguage japanesePerson = new VietnameseToJapaneseAdapter(vietnamesePerson);

        // Người Việt sẽ nói tiếng Việt
        System.out.println("Vietnamese: " + vietnamesePerson.speakVietnamese());

        // Người Nhật sẽ nghe được dịch từ tiếng Việt sang tiếng Nhật thông qua adapter
        System.out.println(japanesePerson.speakJapanese());
    }
}