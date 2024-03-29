package product;

public class Product {
	
	private int id;
	private String name;
	private String supplier;
	private double sale;
	private double buy;
	private String stock;
	
	public Product() {
		super();
	}
	public Product(int id, String name, String supplier, double sale, double buy, String stock) {
		super();
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.sale = sale;
		this.buy = buy;
		this.stock = stock;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", supplier=" + supplier + ", sale=" + sale + ", buy=" + buy
				+ ", stock=" + stock + "]";
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	public double getBuy() {
		return buy;
	}
	public void setBuy(double buy) {
		this.buy = buy;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}

}
