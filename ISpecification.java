public interface ISpecification <T>{

    Iterable<String> ReasonsForDissatisfaction();

    boolean IsSatisfiedBy(T entity);

}