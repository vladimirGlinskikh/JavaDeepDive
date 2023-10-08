package kz.zhelezyaka.solid.isp.withoutISP;

class EFax implements Fax {
	@Override
	public void faxType() {
		System.out.println("Using internet fax to send the fax.");
	}
}