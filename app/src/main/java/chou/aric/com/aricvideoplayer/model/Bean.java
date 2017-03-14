package chou.aric.com.aricvideoplayer.model;

/**
 * Created by aric on 2017/3/11.
 */
public class Bean {
    String title;
    String content;
    String date;
    String comments;
    boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Bean(String title, String content, String date, String comments) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.comments = comments;
    }
}

