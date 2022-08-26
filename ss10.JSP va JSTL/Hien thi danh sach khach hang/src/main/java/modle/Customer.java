package modle;

public class Customer {
    private int id;
    private String name;
    private String ngaySinh;
    private String diaChi;
    private int idImg;

    public Customer() {
    }

    public Customer(int id, String name, String ngaySinh, String diaChi, int idImg) {
        this.id = id;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.idImg = idImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

}
