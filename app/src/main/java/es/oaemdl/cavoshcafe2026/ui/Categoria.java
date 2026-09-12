package es.oaemdl.cavoshcafe2026.ui;

public class Categoria {
    private String name;
    private int iconResId;
    private boolean isSelected;

    public Categoria(String name, int iconResId, boolean isSelected) {
        this.name = name;
        this.iconResId = iconResId;
        this.isSelected = isSelected;
    }

    public String getName() { return name; }
    public int getIconResId() { return iconResId; }
    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { isSelected = selected; }
}