package sample.response.model;

import java.util.Objects;

import lombok.Getter;

@Getter
public class Student implements Comparable<Student> {
	private final String name;
	private final int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	@Override
	public int compareTo(Student o) {
		return this.grade - o.grade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student student))
			return false;
		return getGrade() == student.getGrade() && Objects.equals(getName(), student.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getGrade());
	}
}
