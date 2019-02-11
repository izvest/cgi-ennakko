public interface ISpecification <T>{

    IEnumerable<string> ReasonsForDissatisfaction();

    boolean IsSatisfiedBy(T entity);

}