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

1. Tehtävänannossa annettu koodi on ilmeisesti C#:ia. Koska oma tausta pääosin Javassa ja koska C# / Java jossain määrin sukulaiskieliä, pyrin ratkaisemaan tehtävänannon ensin Javalla ja käännän ratkaisun C#:lle jos ehdin.

2. Alustava ratkaisumalli on varsin kapeatoiminen. Toivotaan vaan että saadaan String sisään todellisen olio-generaalisuuden sijaan. Myöskään  
`ReasonsForDissatisfaction` ei ole vielä käytössä, vaan virheilmoitukset hoituvat toistaiseksi `System.err.println()` funktiolla joka antaa vain yhden virheen kerrallaan ulos.

3. Toinen versio: Lisätty toiminnallisuus `ReasonsForDissatisfaction` funktioon ja siistitty koodia hieman.

4. Kolmas versio: Lisää koodin siistintää, testattu toiminaillisuutta `Test` luokalla. Lisätty myös mahdollisuus käyttää Integeriä syötteenä.