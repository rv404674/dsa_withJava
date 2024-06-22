package solid.MediumBlog;

public class LiskovSubstitutionPrinciple {
    // NOTE: if class B is a subtype of class A, then we should be able to replace
    // object of class A with object of class B without breaking
    // behaviour of the Program.
}

abstract class SocialMedia {
    public abstract void chatWithFriend();
    public abstract void publishPost();
    public abstract void sendPhotosAndVideos();
    public abstract void groupVideoCall();
}

class FaceBook extends SocialMedia {

    @Override
    public void chatWithFriend() {
        // logic
    }

    @Override
    public void publishPost() {
        // logic
    }

    @Override
    public void sendPhotosAndVideos() {
    // lofic
    }

    @Override
    public void groupVideoCall() {
        // logic
    }
}

class WhatsApp extends SocialMedia {

    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost() {
        // NOT APPLICABLE
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall() {

    }
}

// FIXME: violation of L as you can't use whatsapp in replacement of SocialMedia as it doesn't supoort publishPost()


// REFACTORING
interface SocialMediaInterface{
    void chatWithFriend();
    void sendPhotosAndVideos();
}

interface SocialPostAndMediaManager{
    void publishPost();
}

interface VideoCallManager{
    void groupVideoCall();
}

// TODO: NEW DESIGN.
//class NewWhatsApp implements SocialMediaInterface, VideoCallManager {
//
//}
//
//class FacBookNew implements  SocialMediaInterface, SocialPostAndMediaManager, VideoCallManager {
//
//}


