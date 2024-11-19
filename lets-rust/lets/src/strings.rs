pub fn count(that: String) -> usize {
    that.chars().count()
}
pub fn is_empty(that: String) -> bool {
    that.is_empty()
}
pub fn is_not_empty(that: String) -> bool {
    !that.is_empty()
}
pub struct StringWrapper {
    pub wrapper: String,
}
impl StringWrapper {
    pub fn new() -> StringWrapper {
        StringWrapper {
            wrapper: String::new(),
        }
    }

    pub fn append(&mut self, string: &str) -> &StringWrapper {
        self.wrapper.push_str(string);
        return self;
    }

    pub fn append_string(&mut self, string: String) -> &StringWrapper {
        self.wrapper.push_str(string.as_str());
        return self;
    }
    pub fn prepend(&mut self, string: &str) -> &StringWrapper {
        self.wrapper.insert_str(0, string);
        return self;
    }

    pub fn prepend_string(&mut self, string: String) -> &StringWrapper {
        self.wrapper.insert_str(0, string.as_str());
        return self;
    }
    pub fn count(&self) -> usize {
        return self.wrapper.chars().count();
    }
    pub fn is_empty(&self) -> bool {
        return self.wrapper.is_empty();
    }
    pub fn is_not_empty(&self) -> bool {
        return !self.wrapper.is_empty();
    }
}
#[cfg(test)]
mod tests {
    //use crate::add;
    //use super::*;

    use crate::strings::{count, is_empty, is_not_empty, StringWrapper};

    #[test]
    fn it_works() {
        assert_eq!(1, count(String::from("a")));
        assert_eq!(2, count(String::from("中国")));
        assert!(is_empty(String::from("")));
        assert!(is_not_empty(String::from("a")));
    }
    #[test]
    fn string_wrapper_works() {
        let mut string = StringWrapper::new();
        assert!(string.is_empty());
        string.append("a");
        assert!(string.is_not_empty());
        assert_eq!(string.wrapper, String::from("a"));
        string.append("b");
        assert_eq!(string.wrapper, String::from("ab"));
        string.append("中国");
        assert_eq!(string.wrapper, String::from("ab中国"));
        string.prepend("中国");
        assert_eq!(string.wrapper, String::from("中国ab中国"));
    }
}
