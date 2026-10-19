fn c_to_f(c: f64) -> f64 {
    (c * (9.0 / 5.0)) + 32.0
}

fn f_to_c(f: f64) -> f64 {
    (f - 32.0) * (5.0 / 9.0)
}

fn fib(n: u32) -> u64 {
    let mut prev2: u64 = 0;
    let mut prev1: u64 = 1;
    for i in 0..n {
        if i == 0 {
            print!("0 ");
        } else if i == 1 {
            print!(" 1")
        } else {
            match prev1.checked_add(prev2) {
                Some(a) => {
                    prev2 = prev1;
                    prev1 = a;
                    print!(" {}", a);
                }
                None => {
                    println!("\nReached max value for u64");
                    return (i - 1) as u64;
                }
            }
        }
    }
    println!();
    n as u64
}

fn fizz_buzz(n: u32) {
    for i in 1..=n {
        match (i % 3, i % 5) {
            (0, 0) => println!("FizzBuzz"),
            (1, 0) => println!("Fizz"),
            (0, 1) => println!("Buzz"),
            _ => println!("{}", i),
        }
    }
}

fn linear_search(arr: &[i32], target: i32) -> Option<usize> {
    for (i, k) in arr.iter().enumerate() {
        if target == *k {
            return Some(i);
        }
    }
    None
}

fn binary_search(arr: &[i32], target: i32) -> Option<usize> {
    let mut n = arr.len();
    let mut mid = (arr.len() / 2) - 1;
    let mut i = 0;
    while mid < n {
        if target == arr[mid] {
            return Some(mid);
        } else if target > arr[mid] {
            i = mid + 1;
            mid = (i + n) / 2;
        } else {
            n = mid;
            mid = (i + n) / 2;
        }
    }
    None
}

fn main() {
    let centigrate: f64 = 30.5;
    println!("{} in fahrenheit is {}", centigrate, c_to_f(centigrate));
    let fahrenheit = 104f64;
    println!("{} in centigrate is {}", fahrenheit, f_to_c(fahrenheit));

    println!("max n that fits u64 {}", fib(u32::MAX));

    fizz_buzz(20);

    let arr: [i32; 10] = [10, 20, 30, 5, 3, 7, 87, 9, 34, 23];
    let target: i32 = 87;
    match linear_search(&arr, target) {
        Some(a) => println!("Found {} at index {}", target, a),
        None => println!("{} not found", target),
    }

    let arr: [i32; 10] = [10, 15, 20, 25, 30, 35, 40, 45, 50, 55];
    let target: i32 = 17;
    match binary_search(&arr, target) {
        Some(a) => println!("Found {} at index {}", target, a),
        None => println!("{} not found", target),
    }
}
