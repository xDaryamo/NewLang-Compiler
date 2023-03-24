def fibonacci() : void {

    integer t1 << 0, t2 << 1;
    integer next_term;

    next_term << t1 + t2;

    ("Fibonacci sequence: ") --> ;
    (t1 & ", ") --> ;
    (t2 & ", ") --> ;

    for i << 3 to 30 loop {
        (next_term & ", ") --> ;
        t1 << t2;
        t2 << next_term;
        next_term << t1 + t2;
    }
}

def calculate( float x, y | out integer c) : float {

    float result << 0;
    integer index << 0;

    if(c=1) then {

        result << x + y ;
    }

    if(c=2) then {

        result << x - y ;
    }

    if(c=3) then {
        while index < y loop {
            result << result + x;
            index << index + 1;
        }
    }



    if(c=4) then {

       result << x / y ;
    }

    if(c=5) then {

       result << x ^ y ;
    }

    return result ;
}

start:
def calculatorNL() : void {

    float a, b;
    integer choice;
    integer go_on;
    boolean flag << true;
    float result;

    while flag = true loop {

        ("Menu:") -->! ;
        ("1.Sum:") -->! ;
        ("2.Subtraction:") -->! ;
        ("3.Multiplication:") -->! ;
        ("4.Division:") -->! ;
        ("5.Pow:") -->! ;
        ("6.Fibonacci sequence:") -->! ;

        choice <-- "Choose an operation between 1 and 6: ";

        if(choice=6) then {
            fibonacci();
        } else {

            a <-- "Insert first argument value: " ;
            b <-- "Insert second argument value: " ;

            result << calculate(a, b, choice);

            ("Computation result: ") --> ;
            (result) -->! ;
        }

        ("Continue? 0/1: ") --> ;
        go_on <-- ;

        if(go_on=0) then {
            flag << false ;
        }
    }
}