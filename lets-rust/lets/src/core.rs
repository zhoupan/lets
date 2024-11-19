pub const CODE_SUCCESS: i32 = 0;
pub const MESSAGE_SUCCESS: &str = "success";
pub const CODE_FAILURE: i32 = -1;
pub const MESSAGE_FAILURE: &str = "failure";

pub trait Code<TCode> {
    fn code(&self) -> TCode;
}
pub trait Name {
    fn name(&self) -> &str;
}
pub trait Message {
    fn message(&self) -> &str;
}
pub struct EnumSupport<TCode> {
    code: TCode,
    name: &'static str,
    message: &'static str,
}
impl<TCode: PartialEq> EnumSupport<TCode> {
    fn new(code: TCode, name: &'static str, message: &'static str) -> EnumSupport<TCode> {
        EnumSupport {
            code,
            name,
            message,
        }
    }
}

impl<TCode: PartialEq> Name for EnumSupport<TCode> {
    fn name(&self) -> &str {
        self.name
    }
}
impl<TCode: PartialEq> Message for EnumSupport<TCode> {
    fn message(&self) -> &str {
        self.message
    }
}
impl<TCode: PartialEq> PartialEq for EnumSupport<TCode> {
    fn eq(&self, other: &Self) -> bool {
        self.code == other.code
    }
}

pub trait Success {
    fn success(&self) -> bool;
}
pub trait Failure {
    fn failure(&self) -> bool;
}

impl<T, E> Success for Result<T, E> {
    fn success(&self) -> bool {
        self.is_ok()
    }
}
impl<T, E> Failure for Result<T, E> {
    fn failure(&self) -> bool {
        self.is_err()
    }
}

pub struct ResultSupport {
    code: i32,
    success: bool,
    message: &'static str,
}
impl Code<i32> for ResultSupport {
    fn code(&self) -> i32 {
        self.code
    }
}
impl Success for ResultSupport {
    fn success(&self) -> bool {
        self.success
    }
}
impl Failure for ResultSupport {
    fn failure(&self) -> bool {
        !self.success
    }
}
impl Message for ResultSupport {
    fn message(&self) -> &str {
        self.message
    }
}
impl ResultSupport {
    pub fn new(code: i32, success: bool, message: &'static str) -> ResultSupport {
        ResultSupport {
            code,
            success,
            message,
        }
    }
    pub fn success() -> ResultSupport {
        Self::new(CODE_SUCCESS, true, MESSAGE_SUCCESS)
    }
    pub fn success_with_message(message: &'static str) -> ResultSupport {
        Self::new(CODE_SUCCESS, true, message)
    }
    pub fn failure() -> ResultSupport {
        Self::new(CODE_FAILURE, false, MESSAGE_FAILURE)
    }
    pub fn failure_with_message(message: &'static str) -> ResultSupport {
        Self::new(CODE_FAILURE, false, message)
    }
}

pub struct DataResultSupport<T, E> {
    code: i32,
    success: bool,
    message: &'static str,
    data: Option<T>,
    error: Option<E>,
}
impl<T, E> Code<i32> for DataResultSupport<T, E> {
    fn code(&self) -> i32 {
        self.code
    }
}
impl<T, E> Success for DataResultSupport<T, E> {
    fn success(&self) -> bool {
        self.success
    }
}
impl<T, E> Failure for DataResultSupport<T, E> {
    fn failure(&self) -> bool {
        !self.success
    }
}
impl<T, E> Message for DataResultSupport<T, E> {
    fn message(&self) -> &str {
        self.message
    }
}
impl<T, E> DataResultSupport<T, E> {
    pub fn new(code: i32, success: bool, message: &'static str, data: Option<T>, error: Option<E>) -> DataResultSupport<T, E> {
        DataResultSupport {
            code,
            success,
            message,
            data,
            error,
        }
    }
    pub fn success(data: Option<T>) -> DataResultSupport<T, E> {
        Self::new(CODE_SUCCESS, true, MESSAGE_SUCCESS, data, None)
    }
    pub fn success_with_message(data: Option<T>, message: &'static str) -> DataResultSupport<T, E> {
        Self::new(CODE_SUCCESS, true, message, data, None)
    }
    pub fn failure() -> DataResultSupport<T, E> {
        Self::new(CODE_FAILURE, false, MESSAGE_FAILURE, None, None)
    }
    pub fn failure_with_message(message: &'static str) -> DataResultSupport<T, E> {
        Self::new(CODE_FAILURE, false, message, None, None)
    }
    pub fn from(result: Result<T, E>) -> DataResultSupport<T, E> {
        if result.is_ok() {
            Self::new(CODE_SUCCESS, true, MESSAGE_SUCCESS, result.ok(), None)
        } else {
            Self::new(CODE_FAILURE, false, MESSAGE_FAILURE, None, result.err())
        }
    }
}

#[cfg(test)]
mod tests {
    use crate::core::{DataResultSupport, EnumSupport, Failure, ResultSupport, Success};

    #[test]
    fn success_failure_works() {
        let ok: Result<i32, &str> = Ok(0);
        assert!(ok.success());
        assert!(!ok.failure());
        let err: Result<i32, &str> = Err("err");
        assert!(err.failure());
        assert!(!err.success());
    }
    #[test]
    fn result_support_works() {
        let ok = ResultSupport::success();
        assert!(ok.success());
        assert!(!ok.failure());
        let err = ResultSupport::failure();
        assert!(err.failure());
        assert!(!err.success());
        //mut
        let mut result: ResultSupport = ResultSupport {
            code: 0,
            success: true,
            message: "",
        };
        assert!(result.success());
        assert!(!result.failure());
        result.success = false;
        assert!(!result.success());
        assert!(result.failure());
    }
    #[test]
    fn data_result_support_works() {
        let ok: DataResultSupport<i32, &str> = DataResultSupport::success(Some(0));
        assert!(ok.success());
        assert!(!ok.failure());
        assert_eq!(Some(0), ok.data);
        assert_eq!(0, ok.data.unwrap_or(1));
        assert_eq!(None, ok.error);
        let err: DataResultSupport<i32, &str> = DataResultSupport::failure();
        assert!(err.failure());
        assert!(!err.success());
        //mut
        let mut result: DataResultSupport<i32, &str> = DataResultSupport::success(Some(0));
        assert!(result.success());
        assert!(!result.failure());
        result.success = false;
        assert!(!result.success());
        assert!(result.failure());
        result.data = Some(0);
        assert_eq!(Some(0), result.data);
        result.data = None;
        assert_eq!(None, result.data);
        result.error = Some("404");
        assert_eq!(Some("404"), result.error);
    }
    #[test]
    fn enum_support_works() {
        let ok: EnumSupport<i32> = EnumSupport::new(0, "ok", "ok");
        let error: EnumSupport<i32> = EnumSupport::new(404, "err", "err");
        let http_error: EnumSupport<i32> = EnumSupport::new(404, "404", "Page Not Found");
        //eq by code
        assert!(error == http_error);
        assert!(ok != error);
    }
}