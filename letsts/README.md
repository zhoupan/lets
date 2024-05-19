# Let's TypeScript

## Development

- Why you should prefer using pnpm over npm and yarn?

  Pnpm in known as "Performant NPM" but to be precise it is a "Fast, disk space efficient package manager." It's an alternative package manager for Node.js applications that aims to solve some of the limitations and inefficiencies found in traditional package managers like npm and Yarn.

  One of the key differences with pnpm is its approach to package installation. Instead of duplicating dependencies in each project directory, pnpm uses a unique approach called "hard linking" to store packages in a global store. This drastically reduces the amount of disk space required and speeds up the installation process.

- Prepare node and pnpm (node>=20 && pnpm>= 9)

  ```
  $ node -v
  $ v20.12.2
  $ corepack enable
  $ corepack prepare pnpm@latest --activate
  $ pnpm -v
  $ 9.0.6
  ```

- Prepare a package.json.

  ```
  $ pnpm init
  ```

  This will create a package.json for you.

- Prepare typescript.

  ```
  $ pnpm install typescript ts-node
  ```

  This will install dependencies, update package.json and pnpm-lock.yaml for you, and install both TypeScript and ts-node (a package that allows you to run TypeScript directly from Node.js).

- Running TypeScript from the terminal.

  ```
  $ pnpm ts-node ./src/helloworld.ts
  ```

- Installing a Dependency.

  ```
  $ pnpm install <package>
  ```

- Removing a Dependency.

  ```
  $ pnpm uninstall <package>
  ```

- Updating All Packages.

  ```
  $ pnpm update
  ```

- Using pnpx to Execute a Script Only Once.

  ```
  $ pnpx ts-node ./src/helloworld.ts
  ```

- Define consistent coding styles with .editorconfig.

  ```ini
  # .editorconfig
  root = true
  [*]
  indent_style = space
  indent_size = 2
  max_line_length= 100
  # We recommend you to keep these unchanged
  end_of_line = lf
  charset = utf-8
  trim_trailing_whitespace = true
  insert_final_newline = true
  ```

- Define consistent coding format with Prettier.

  ```
  $ pnpm add --save-dev --save-exact prettier @prettier/plugin-xml prettier-plugin-organize-imports prettier-eslint
  ```

  ```json
  // .prettierrc
  {
    "plugins": ["prettier-plugin-organize-imports", "@prettier/plugin-xml"],
    "printWidth": 100,
    "tabWidth": 2,
    "useTabs": false,
    "xmlWhitespaceSensitivity": "ignore"
  }
  ```

- Formatting code.

  ```
  $ pnpm format
  ```
