
        var smerKonverzije = 'cirilica';

        function postaviSmerKonverzije(smer) {
            smerKonverzije = smer;
            konvertujTekst('latin', 'cirilica'); 
        }

        function konvertujTekst(sourceId, targetId) {
            
            var sourceInput = document.getElementById(sourceId);
            var targetInput = document.getElementById(targetId);

            var inputValue = sourceInput.value;

            
            if (smerKonverzije === 'cirilica') {
                targetInput.value = konvertujLatinUcirilicu(inputValue);
            } else {
                targetInput.value = konvertujCirilicuUlatin(inputValue);
            }
        }

    
        function konvertujLatinUcirilicu(text) {
            return text
                .replace(/Lj/g, 'Љ')
                .replace(/Nj/g, 'Њ')
                .replace(/Dž/g, 'Џ')
                .replace(/dž/g, 'џ')
                .replace(/Dj/g, 'Ђ')
                .replace(/dj/g, 'ђ')
                .replace(/nj/g, 'њ')
                .replace(/lj/g, 'љ')
                .replace(/a/g, 'а')
                .replace(/b/g, 'б')
                .replace(/c/g, 'ц')
                .replace(/d/g, 'д')
                .replace(/e/g, 'е')
                .replace(/f/g, 'ф')
                .replace(/g/g, 'г')
                .replace(/h/g, 'х')
                .replace(/i/g, 'и')
                .replace(/j/g, 'ј')
                .replace(/k/g, 'к')
                .replace(/l/g, 'л')
                .replace(/m/g, 'м')
                .replace(/n/g, 'н')
                .replace(/o/g, 'о')
                .replace(/p/g, 'п')
                .replace(/q/g, 'к')
                .replace(/r/g, 'р')
                .replace(/s/g, 'с')
                .replace(/t/g, 'т')
                .replace(/u/g, 'у')
                .replace(/v/g, 'в')
                .replace(/w/g, 'в')
                .replace(/x/g, 'кс')
                .replace(/y/g, 'и')
                .replace(/z/g, 'з')
                .replace(/đ/g, 'ђ')
                .replace(/ž/g, 'ж')
                .replace(/š/g, 'ш')
                .replace(/č/g, 'ч')
                .replace(/ć/g, 'ћ')
                .replace(/A/g, 'А')
                .replace(/B/g, 'Б')
                .replace(/C/g, 'Ц')
                .replace(/D/g, 'Д')
                .replace(/E/g, 'Е')
                .replace(/F/g, 'Ф')
                .replace(/G/g, 'Г')
                .replace(/H/g, 'Х')
                .replace(/I/g, 'И')
                .replace(/J/g, 'Ј')
                .replace(/K/g, 'К')
                .replace(/L/g, 'Л')
                .replace(/M/g, 'М')
                .replace(/N/g, 'Н')
                .replace(/O/g, 'О')
                .replace(/P/g, 'П')
                .replace(/Q/g, 'К')
                .replace(/R/g, 'Р')
                .replace(/S/g, 'С')
                .replace(/T/g, 'Т')
                .replace(/U/g, 'У')
                .replace(/V/g, 'В')
                .replace(/W/g, 'В')
                .replace(/X/g, 'КС')
                .replace(/Y/g, 'И')
                .replace(/Z/g, 'З')
                .replace(/Đ/g, 'Ђ')
                .replace(/Ž/g, 'Ж')
                .replace(/Š/g, 'Ш')
                .replace(/Č/g, 'Ч')
                .replace(/Ć/g, 'Ћ');
        }

        
        function konvertujCirilicuUlatin(text) {
            return text
                .replace(/Љ/g, 'Lj')
                .replace(/Њ/g, 'Nj')
                .replace(/Џ/g, 'Dž')
                .replace(/џ/g, 'dž')
                .replace(/Ђ/g, 'Dj')
                .replace(/ђ/g, 'dj')
                .replace(/њ/g, 'nj')
                .replace(/љ/g, 'lj')
                .replace(/а/g, 'a')
                .replace(/б/g, 'b')
                .replace(/ц/g, 'c')
                .replace(/д/g, 'd')
                .replace(/е/g, 'e')
                .replace(/ф/g, 'f')
                .replace(/г/g, 'g')
                .replace(/х/g, 'h')
                .replace(/и/g, 'i')
                .replace(/ј/g, 'j')
                .replace(/к/g, 'k')
                .replace(/л/g, 'l')
                .replace(/м/g, 'm')
                .replace(/н/g, 'n')
                .replace(/о/g, 'o')
                .replace(/п/g, 'p')
                .replace(/р/g, 'r')
                .replace(/с/g, 's')
                .replace(/т/g, 't')
                .replace(/у/g, 'u')
                .replace(/в/g, 'v')
                .replace(/з/g, 'z')
                .replace(/ђ/g, 'đ')
                .replace(/ж/g, 'ž')
                .replace(/ш/g, 'š')
                .replace(/ч/g, 'č')
                .replace(/ћ/g, 'ć')
                .replace(/А/g, 'A')
                .replace(/Б/g, 'B')
                .replace(/Ц/g, 'C')
                .replace(/Д/g, 'D')
                .replace(/Е/g, 'E')
                .replace(/Ф/g, 'F')
                .replace(/Г/g, 'G')
                .replace(/Х/g, 'H')
                .replace(/И/g, 'I')
                .replace(/Ј/g, 'J')
                .replace(/К/g, 'K')
                .replace(/Л/g, 'L')
                .replace(/М/g, 'М')
                .replace(/Н/g, 'N')
                .replace(/О/g, 'O')
                .replace(/П/g, 'P')
                .replace(/R/g, 'Р')
                .replace(/С/g, 'S')
                .replace(/Т/g, 'T')
                .replace(/У/g, 'U')
                .replace(/В/g, 'V')
                .replace(/И/g, 'Y')
                .replace(/З/g, 'Z')
                .replace(/Ђ/g, 'Đ')
                .replace(/Ж/g, 'Ž')
                .replace(/Ш/g, 'Š')
                .replace(/Ч/g, 'Č')
                .replace(/Ћ/g, 'Ć');
        }