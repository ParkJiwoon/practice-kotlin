package com.bcp0109.springwebfluxkotlin.mono

import com.bcp0109.springwebfluxkotlin.domain.Member
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class MemberService(
    private val memberRepository: MemoryMemberRepository
) {
    val log: Logger = LoggerFactory.getLogger(MemberService::class.java)

    fun signup(name: String, age: Int): Mono<Member> {
        val member = Member(name, age)
        return memberRepository.save(member)
    }

    fun findMemberById(memberId: Long): Mono<Member> {
        return memberRepository.findById(memberId)
    }

    fun findAll(): Flux<Member> {
        return memberRepository.findAll()
    }
}
