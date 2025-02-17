package org.finos.springbot.tool.poll.poll;

import java.time.temporal.ChronoUnit;

import org.apache.commons.lang3.StringUtils;
import org.finos.springbot.workflow.annotations.Template;
import org.finos.springbot.workflow.annotations.Work;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Work
@Template(edit="poll-create-form")
public class PollCreateForm {

	enum TimeUnit {
		MINUTES, HOURS, DAYS;
		
		public ChronoUnit getChronoUnit() {
			switch (this) {
			case MINUTES:
				return ChronoUnit.MINUTES;
			case HOURS:
				return ChronoUnit.HOURS;
			case DAYS:
			default:
				return ChronoUnit.DAYS;
			}
		}

		public String toString() {
			return StringUtils.capitalize(this.name().toLowerCase());
		}
	};

	public String question;

	public String option1;
	public String option2;
	public String option3;
	public String option4;
	public String option5;
	public String option6;

	@Min(0)
	@Max(60)
	private Integer time = 15;
	private TimeUnit timeUnit = TimeUnit.MINUTES;
	
	private boolean endAutomatically = true;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getOption5() {
		return option5;
	}

	public void setOption5(String option5) {
		this.option5 = option5;
	}

	public String getOption6() {
		return option6;
	}

	public void setOption6(String option6) {
		this.option6 = option6;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	public boolean isEndAutomatically() {
		return endAutomatically;
	}

	public void setEndAutomatically(boolean endAutomatically) {
		this.endAutomatically = endAutomatically;
	}

}
