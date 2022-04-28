package com.bilgeadam.lesson014;

public class Printer {
	private static final double CRITICAL_TONER_LEVEL  = 0.10d;
	private static final double TONER_USAGE_PER_SHEET = 0.01d;

	private String  printerName;     // yazıcımızın ismi
	private double  tonerLevel;      // anlık toner seviye bilgisi
	private int     printedBWPages;  // toplamda kaç adet siyah/beyaz sayfa basmış
	private int     printedColPages; // toplamda kaç adet renkli sayfa basmış
	private boolean dublexCapable;   // duplex printing yapabiliyor mu;
	private boolean colorCapable;    // renli printing yapabiliyor mu?
	private int     numPapers;       // yazıcıda kaç kağıt var?

	public Printer() {
		this.tonerLevel      = 100.0; // yeni bir yazıcı yarattığımızda toner'ı dolu gelir
		this.printedBWPages  = 0;     // yeni bir yazıcı yarattığımızda toplam basılan S/B sayfa sayısı 0'dır
		this.printedColPages = 0;     // yeni bir yazıcı yarattığımızda toplam basılan renkli sayfa sayısı 0'dır
		this.numPapers       = 0;     // yeni bir yazıcı yarattığımızda içinde kağıt yok
	}

	public void startPrintJob(int numPages, boolean colorPrint, boolean dublexPrint) {
		if (!isTonerLevelSufficient()) {
			this.fillToner(100.0);
		}
		int printedSheets = 1;
		while (printedSheets <= numPages) {
			
		}
		this.endPrintJob();
	}
	
	private void endPrintJob() {
		System.out.println("Baskı başarı ile tamamlandı");
		this.statusReport();
	}

	private boolean isTonerLevelSufficient() {
		return this.tonerLevel >= Printer.CRITICAL_TONER_LEVEL;
	}

	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	public void fillToner(double tonerLevel) {
		this.tonerLevel = tonerLevel;
	}

	public void setDublexCapable(boolean dublexCapable) {
		this.dublexCapable = dublexCapable;
	}

	public void setColorCapable(boolean colorCapable) {
		this.colorCapable = colorCapable;
	}

	public void fillPaper(int paperAmount) {
		this.numPapers = paperAmount;
	}

	public void statusReport() {
		System.out.println("Yazıcı adı:\t" + this.printerName);
		int totalPages = printedBWPages + printedColPages;
		System.out.println("Toplam yazılan sayfa:\t" + totalPages);
		if (totalPages > 0) {
			System.out.println("S/B yazılan sayfa:\t" + printedBWPages + "\t (" + (printedBWPages / totalPages) + "%)");
			System.out.println("Renkli yazılan sayfa:\t" + printedColPages + "\t (" + (printedColPages / totalPages) + "%)");
		}
	}

	@Override
	public String toString() {
		return "Printer [printerName=" + this.printerName + ", tonerLevel=" + this.tonerLevel + ", printedBWPages="
				+ this.printedBWPages + ", printedColPages=" + this.printedColPages + ", dublexCapable="
				+ this.dublexCapable + ", colorCapable=" + this.colorCapable + ", numPapers=" + this.numPapers + "]";
	}

	public boolean isDublexCapable() {
		return this.dublexCapable;
	}

	public boolean isColorCapable() {
		return this.colorCapable;
	}
}
