# Introduction:
| Feature                  | React                       | Next.js                         |
|--------------------------|-----------------------------|---------------------------------|
| **Type**                 | Library                     | Framework                       |
| **Rendering**            | Client-Side Rendering (CSR) | SSR, SSG, CSR, Hybrid           |
| **Routing**              | Requires React Router       | Built-in file-based routing     |
| **API Routes**           | Not available [^1]          | Built-in API routes [^2]        |
| **SEO**                  | Poor (CSR)                  | Excellent (SSR/SSG)             |
| **Performance**          | Slower initial load         | Faster (SSR/SSG)                |
| **Static Site Generation**| Not supported natively [^3] | Built-in SSG                    |
| **Deployment**           | Static files                | Static, SSR, or hybrid          |
| **Learning Curve**       | Lower                       | Higher (requires React knowledge) |

[^1]: You need to set up a separate backend (e.g., Node.js, Express) to handle API requests.
[^2]: You can create backend endpoints directly within your Next.js application by adding files to the `pages/api` directory.
[^3]: You would need to use additional tools like [Gatsby](https://www.gatsbyjs.com/) to generate static sites.

## Workflow

![Workflow](./images/img.png)

## Folder Structure
```
my-next-app/
├── .next/                  # Next.js build output (automatically generated)
├── node_modules/           # Installed dependencies (automatically generated)
├── public/                 # Static assets (e.g., images, fonts)
│   ├── vercel.svg          # Example static file
│   └── favicon.ico         # Favicon
├── app/                    # App Router (replaces `pages`)
│   ├── (auth)/             # Route group (optional)
│   │   └── login/          # Nested route
│   │       └── page.js     # Login page
│   ├── about/              # Route segment
│   │   └── page.js         # About page
│   ├── api/                # API routes
│   │   └── hello/          # API route
│   │       └── route.js    # API handler
│   ├── layout.js           # Root layout
│   ├── page.js             # Home page
│   └── globals.css         # Global styles
├── .gitignore              # Files to ignore in Git
├── eslint.config.mjs       # ESLint configuration, used to find and fix problems in JS code
├── jsconfig.json           # JavaScript configuration (e.g., path aliases)
├── next.config.mjs         # Next.js configuration, mjs indicate that it uses ES Modules (ESM) syntax
├── package-lock.json       # Dependency lock file (if using npm)
├── package.json            # Project dependencies and scripts
├── postcss.config.mjs      # PostCSS configuration
├── tailwind.config.mjs     # Tailwind CSS configuration
└── README.md               # Project documentation

```

## NextJS uses ES6 Standard
ES6 defines the JavaScript programming language. Most modern browsers fully support ES6. For older browsers, [Babel](https://babeljs.io/) can convert ES6 code into ES5 for compatibility.

### Key features
1. `let`, replaces `var` and `const` for Variable Declarations
```javascript
let x = 10;
const y = 20; 
```
2. Arrow functions
```javascript
const add = (a, b) => a + b;
console.log(add(2, 3)); 
```
3. Template Literals
```javascript
const name = "Abraham";
console.log(`Hello, ${name}!`); 
```
4. Destructuring Assignment
> Extract values from arrays or objects into variables.
```javascript
const [a, b] = [1, 2];
console.log(a, b);
```

5.  Default Parameters
> Set default values for function parameters.
```javascript
function greet(name = "Guest") {
  return `Hello, ${name}!`;
}
console.log(greet());
```
6. Spread and Rest Operators
> Spread (...): Expands an array or object into individual elements.
> 
> Rest (...): Collects multiple elements into an array.
```javascript
// Spread
const arr = [1, 2, 3];
const newArr = [...arr, 4, 5];

// Rest
function sum(...numbers) {
    let total = 0;
    for (let num of numbers) {
        total += num;
    }
    return total;
}

console.log(sum(1, 2, 3));
```
7. Classes
> Makes object-oriented programming easier.
```javascript
class Person {
  constructor(name) {
    this.name = name;
  }
  greet() {
    console.log(`Hello, ${this.name}!`);
  }
}
const alice = new Person("Isaac");
alice.greet();
```
8. Modules
```javascript
// math.js
export const add = (a, b) => a + b;

// app.js
import { add } from './math.js';
console.log(add(2, 3));
```
9. Promises
> A Promise is a way to handle async operations.
>
> It avoids callback hell and makes code cleaner.
```javascript
const fetchData = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve("Data fetched!"), 1000);
  });
};

fetchData().then(data => console.log(data));
```
10. Enhanced Object Literals
> Shorter syntax for defining object properties and methods.
```javascript
const name = "Bianca";
const age = 25;

const person = { name, age, greet() { console.log(`Hello, ${this.name}!`); } };
person.greet(); 
```
11. Iterators and Generators
> Iterators: Objects that define a sequence and a return value.
>
> Generators: Functions that can be paused and resumed.
```javascript
// Generator
function* generator() {
  yield 1;
  yield 2;
  yield 3;
}

// Iterator
const gen = generator();
console.log(gen.next().value); 
console.log(gen.next().value); 
```
12. Map and Set
> Map: A collection of key-value pairs.
>
> Set: A collection of unique values.
```javascript
// Map
const map = new Map();
map.set("name", "Aaron");
console.log(map.get("name")); // Aaron

// Set
const set = new Set([1, 2, 3, 3]);
console.log([...set]); // [1, 2, 3]
```
13. Symbol
> A unique and immutable primitive value, often used as object property keys.
```javascript
const id = Symbol("id");
const user = { [id]: 123, name: "Sarah" };
console.log(user[id]); 
```
