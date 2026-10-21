enum Direction {
    Up,
    Down,
    Left,
    Right,
}

fn which_way(go: Direction) {
    match go {
        Direction::Up => println!("up"),
        Direction::Left => println!("left"),
        Direction::Down => println!("down"),
        Direction::Right => println!("right"),
    }
}

fn add(a: i32, b: i32) -> i32 {
    a + b
}

enum Flavor {
    Sparkling,
    Sweet,
    Fruity,
}

struct Drink {
    flavor: Flavor,
    fluid_oz: f64,
}

fn print_drink(drink: Drink) {
    match drink.flavor {
        Flavor::Fruity => println!("fruity"),
        Flavor::Sparkling => println!("sparkling"),
        Flavor::Sweet => println!("sweet"),
    }
    println!("oz: {:?}", drink.fluid_oz);
}

fn calculate_total(base: u32, tax: u32, shipping: u32) -> Option<u32> {
    base.checked_add(tax)
        .and_then(|sum_so_far| sum_so_far.checked_add(shipping))
}

fn main() {
    println!("Hello, World!");
    println!("{}", add(5, 10));
    println!("{:?}", add(20, 30)); //debug
    let a = 99;

    if a > 99 {
        println!("Big number");
    } else {
        println!("Small number");
    }
    //loops
    let mut a = 0;
    loop {
        if a == 5 {
            break;
        }
        println!("{:?}", a);
        a += 1;
    }
    a = 0;
    while a != 5 {
        println!("{:?}", a);
        a += 1;
    }

    let some_bool = true;
    match some_bool {
        true => println!("its true"),
        false => println!("its false"),
    }

    let some_int = 3;
    match some_int {
        1 => println!("its 1"),
        2 => println!("its 2"),
        _ => println!("its some other number"),
    }

    let go = Direction::Up;

    which_way(go);

    let sweet = Drink {
        flavor: Flavor::Fruity,
        fluid_oz: 1.2,
    };

    print_drink(sweet);

    let safe_total = calculate_total(100, 15, 10);
    println!("Total: {:?}", safe_total); // Some(125)

    // Fails safely because it overflows u32::MAX
    let dangerous_total = calculate_total(u32::MAX, 1, 10);
    println!("Total: {:?}", dangerous_total); // None
}
