package contactlist.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@SuppressWarnings("serial")
public class Birthday implements Serializable {

	@NotNull
	@Column(name = "BIRTHDAY_DAY")
	private Integer day;

	@NotNull
	@Column(name = "BIRTHDAY_MONTH")
	private Integer month;

	@Column(name = "BIRTHDAY_YEAR")
	private Integer year;

	public Birthday() {
	}

	public Birthday(Integer year, Integer month, Integer day) {
		this(month, day);
		this.year = year;
	}

	public Birthday(Integer month, Integer day) {
		this.month = month;
		this.day = day;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
