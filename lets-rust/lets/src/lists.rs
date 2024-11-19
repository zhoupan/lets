pub struct ListWrapper<T: PartialEq> {
    pub wrapper: Vec<T>,
}

impl<T: PartialEq> ListWrapper<T> {
    pub fn new() -> ListWrapper<T> {
        ListWrapper {
            wrapper: Vec::new(),
        }
    }
    pub fn size(&self) -> usize {
        self.wrapper.len()
    }
    pub fn is_empty(&self) -> bool {
        self.wrapper.is_empty()
    }
    pub fn is_not_empty(&self) -> bool {
        !self.wrapper.is_empty()
    }
    pub fn append(&mut self, v: T) -> &ListWrapper<T> {
        self.wrapper.push(v);
        self
    }
    pub fn prepend(&mut self, v: T) -> &ListWrapper<T> {
        self.wrapper.insert(0, v);
        self
    }
    pub fn remove(&mut self, v: T) -> &ListWrapper<T> {
        self.wrapper.retain(|x| *x != v);
        self
    }
    pub fn contains(&self, v: T) -> bool {
        self.wrapper.contains(&v)
    }
    pub fn insert(&mut self, index: usize, v: T) -> &ListWrapper<T> {
        self.wrapper.insert(index, v);
        self
    }
}

#[cfg(test)]
mod tests {
    //use crate::add;
    //use super::*;

    use crate::lists::ListWrapper;

    #[test]
    fn list_wrapper_works() {
        let mut string: ListWrapper<&str> = ListWrapper::new();
        assert!(string.is_empty());
        string.append("a");
        assert!(string.is_not_empty());
        assert!(string.contains("a"));
        string.prepend("b");
        assert!(string.contains("b"));
        let get = string.wrapper.get(0);
    }
}
