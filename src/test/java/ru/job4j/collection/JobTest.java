package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    @DisplayName("Сортировка сперва по имени и после по приоритету DESC")
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    @DisplayName("Сортировка сперва по имени и после по приоритету ASC")
    public void whenComparatorAscByPriorityAndName() {
        Comparator<Job> cmpNamePriority =
                new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    @DisplayName("Сортировка DESC по имени")
    public void whenComparatorDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Xmpl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    @DisplayName("Сортировка DESC по приоритету")
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Xmpl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    @DisplayName("Сортировка DESC по приоритету с одинаковым значением")
    public void whenComparatorDescByPriorityWithEqualsPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Other task", 3),
                new Job("Fix bug", 3)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    @DisplayName("Сортировка ASC по имени")
    public void whenComparatorAscByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("Xmpl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    @DisplayName("Сортировка ASC по приоритету")
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Xmpl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    @DisplayName("Сортировка ASC по приоритету с одинаковым значением")
    public void whenComparatorAscByPriorityWithEqualsPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Other task", 3),
                new Job("Fix bug", 3)
        );
        assertThat(rsl).isEqualTo(0);
    }
}