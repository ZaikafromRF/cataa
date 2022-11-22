/**1)операции +, -, * и / с двумя числами +
 2)с арабскими, c римскими числами. +
 3)Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. +
 4)Калькулятор умеет работать только с целыми числами. +
 5)Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, исключение+
 6)При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно+
 7)При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.+
 8)исключение при не верной операции+
 9)Результатом операции деления является целое число, остаток отбрасывается.
 10)Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.+
 Результатом работы калькулятора с римскими числами могут быть только положительные числа,
 если результат работы меньше единицы, выбрасывается исключение**/
import java.io.IOException;
import java.util.Scanner;


public class Main
{
    public static String[] calc(String input) throws IOException
    {

        String[] lin =input.split(" ");
        if (lin.length>3)
        {
            throw new IOException("false input");
        }
        return lin;
    };
    public static void main(String[] args) throws IOException
    {
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
        String[] rome = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        Scanner linin = new Scanner(System.in);
        System.out.print("Input: ");
        String lini =linin.nextLine();
        String[] lin=calc(lini);
        String str1 = lin[0];
        String str2 = lin[2];
        char op = lin[1].charAt(0);
        char[] oper=  {'+','-','*','/'};
        int x =1;
        boolean ch1 = false, ch2 = false, ch3 = false, ch4 = false, ch5=false;
        int num1 = 0, num2 = 0, c1 = 0;
        for (char i: oper)
        {
            if(i==op)
            {
                ch5=true;
            }
        }
        if (ch5==false)//point 5
        {
            throw new IOException("different operation");
        }
        for (String i:rome)//rome check
        {
            c1++;
            if (i.equals(str1))
            {
                ch1=true;
                num1=c1-1;
            }
            if(i.equals(str2))
            {
                ch2=true;
                num2=c1-1;
            }

        }
        for (int i =0;i<10;i++)//arab check
        {
            c1++;
            if (arab[i].equals(str1))
            {
                ch3=true;
                num1=c1;
            }
            if(arab[i].equals(str2))
            {
                ch4=true;
                num2=c1;
            }
        }
        if (ch1==false && ch2==false && ch3==false && ch4==false)//point 7
        {
            System.out.print(ch3);
            throw new IOException("not cool input");
        }
        if (ch1==true && ch2==true)//rome count + rom output
        {
            str1="";
            switch (op)
            {
                case ('+'): {
                    num1 += num2;
                    break;
                }
                case ('-'):
                {
                    num1-=num2;
                    break;

                }
                case('*'):
                {
                    num1*=num2;
                    break;
                }
                case('/'):
                {
                    num1/=num2;
                    break;
                }
                default:
                    System.out.print("u're good boy");
                    break;
            }
            if (num1<0)
            {
                throw new IOException("too small nums");
            }
            str1=rome[num1];
            System.out.print(str1);
        }
        else if (ch3==true && ch4==true)//arab count + arab output
        {
            num1=Integer.parseInt(str1);
            num2=Integer.parseInt(str2);
            switch (op)
            {
                case ('+'): {
                    num1 += num2;
                    break;
                }
                case ('-'):
                {
                    num1-=num2;
                    break;

                }
                case('*'):
                {
                    num1*=num2;
                    break;
                }
                case('/'):
                {
                    num1/=num2;
                    break;
                }
                default:
                    System.out.print("u're good boy");
                    break;
            }
            System.out.println((num1));
        }
        else //non rome or arab signs
        {
            throw new IOException("different nums input");
        }
    }

}

//Извиняюсь за такой код. java тяжко даётся что-то^^