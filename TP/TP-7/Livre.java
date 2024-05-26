import notices.NoticeBibliographique;

public class Livre {
    private int code;
    private NoticeBibliographique notice;

    public Livre(int code, NoticeBibliographique notice) {
        this.code = code;
        this.notice = notice;
    }

    public int getCode() {
        return code;
    }

    public NoticeBibliographique getNotice() {
        return notice;
    }

    @Override
    public String toString() {
        return notice.getTitre() +
                "(code=" + code +
                ")";
    }
}
