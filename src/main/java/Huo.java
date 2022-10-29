class Huo {
    int seq;
    String date;
    String title;
    String person;
    String url;
    String id;

    public Huo(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public Huo(int seq, String date, String title, String person, String url, String id) {
        this.seq = seq;
        this.date = date;
        this.title = title;
        this.id = id;
        this.person = person;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Huo{" +
                "seq=" + seq +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", person=" + person +
                ", url='" + url + '\'' +
                '}';
    }
}