# CGI Future Talent - Ennakkoetehtävänanto

### Tee luokka BusinessIdSpecification, joka toteuttaa seuraavan rajapinnan:

 
```c#
public interface ISpecification<in TEntity>

{

    IEnumerable<string> ReasonsForDissatisfaction { get; }

    bool IsSatisfiedBy(TEntity entity);

}
```
 

Luokan tehtävänä on tarkistaa merkkijonona annetun y-tunnuksen oikeellisuus, ja kertoa, miksi epäkelpo y-tunnus ei täytä vaatimuksia. Toteutuksen toimivuuden lisäksi arvioimme myös mm. toteutuksen ylläpidettävyyttä. Laita toteutuksesi GitHubiin ja lähetä meille siihen linkki.

#### Omat kommentit

1. Tehtävänannossa annettu koodi on ilmeisesti C#:ia
 a. Koska C# ja Java jossain määrin sukulaiskieliä, pyrin ratkaisemaan tehtävänannon ensin Javassa
