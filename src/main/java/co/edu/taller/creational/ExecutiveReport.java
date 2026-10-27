package co.edu.taller.creational;

import java.util.*;

public class ExecutiveReport {
    private final String title, period;
    private final List<String> sections;

    private ExecutiveReport(Builder report) {
        title = report.title;
        period = report.period;
        sections = List.copyOf(report.sections);
    }

    public String title() {
        return title;
    }

    public String period() {
        return period;
    }

    public List<String> sections() {
        return sections;
    }

    public static class Builder {
        private String title, period;
        private final List<String> sections = new ArrayList<>();

        public Builder title(String titleName) {
            title = titleName;
            return this;
        }

        public Builder period(String periodTime) {
            period = periodTime;
            return this;
        }

        public Builder addSection(String addedSection) {
            sections.add(addedSection);
            return this;
        }

        public ExecutiveReport build() {
            if (title == null || title.isBlank() || period == null || period.isBlank()) {
                throw new IllegalStateException("El título y el periodo son obligatorios");
            }
            return new ExecutiveReport(this);
        }
    }
}